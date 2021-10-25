package by.training.barbershop.service.impl;

import by.training.barbershop.bean.User;
import by.training.barbershop.bean.UserInfo;
import by.training.barbershop.bean.UserRole;
import by.training.barbershop.bean.UserStatus;
import by.training.barbershop.dao.TransactionDao;
import by.training.barbershop.dao.UserDao;
import by.training.barbershop.dao.UserInfoDao;
import by.training.barbershop.dao.exception.DaoException;
import by.training.barbershop.dao.impl.AbstractDao;
import by.training.barbershop.dao.impl.DaoFactory;
import by.training.barbershop.service.UserService;
import by.training.barbershop.service.exception.ServiceException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.List;


public class UserServiceImpl implements UserService {
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public User findRegisteredUser(String login, String password) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) userDao, (AbstractDao) userInfoDao);
        if (login == null || password == null) {
            return null;
        }
        try {
            User user = userDao.findUserByLogin(login);
            UserInfo userInfo = userInfoDao.findEntityById(user.getId());
            user.setUserInfo(userInfo);
            transactionDao.commit();
            if (validatePassword(password, user.getPassword())) {
                return user;
            } else {
                return null;
            }
        } catch (DaoException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            transactionDao.rollback();
            throw new ServiceException(e);
        } finally {
            transactionDao.endTransaction();
        }
    }

    @Override
    public boolean addNewUser(User user) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) userDao, (AbstractDao) userInfoDao);
        try {
            if (user != null) {
                String password = user.getPassword();
                user.setPassword(generateStrongPasswordHash(password));
                transactionDao.commit();
                UserInfo userInfo = user.getUserInfo();
                int idUser = userDao.create(user);
                userInfo.setId(idUser);
                userInfoDao.create(userInfo);

                transactionDao.commit();
                return true;
            }
        } catch (DaoException | NoSuchAlgorithmException | InvalidKeySpecException | SQLException e) {
            transactionDao.rollback();
            throw new ServiceException(e);
        } finally {
            transactionDao.endTransaction();
        }
        return false;
    }

    @Override
    public User findUserById(int id) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) userDao);
        try {
            return userDao.findEntityById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        } finally {
            transactionDao.endTransaction();
        }
    }

    @Override
    public boolean updateUser(User user) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) userDao, (AbstractDao) userInfoDao);
        try {
            if (user != null) {
                String password = user.getPassword();
                String passwordFromDb = userDao.findEntityById(user.getId()).getPassword();
                if (!password.equals(passwordFromDb)) {
                    user.setPassword(generateStrongPasswordHash(password));
                }
                userInfoDao.update(user.getUserInfo());
                userDao.update(user);
                transactionDao.commit();
                return true;
            }
        } catch (DaoException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            transactionDao.rollback();
            throw new ServiceException(e);
        } finally {
            transactionDao.endTransaction();
        }
        return false;
    }

    @Override
    public boolean isLoginFreeForNewUser(String login) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) userDao);
        try {
            return userDao.findUserByLogin(login) != null;
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transactionDao.end();
        }
    }

    @Override
    public List<User> findAllUser() throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) userDao, (AbstractDao) userInfoDao);
        try {
            List<User> users = userDao.findAll();
            List<UserInfo> userInfos = userInfoDao.findAll();
            users.removeIf(admin -> admin.getRole().equals(UserRole.ADMIN));
            for (var user : users) {
                for (var userInfo : userInfos) {
                    if (user.getId() == userInfo.getId()) {
                        user.setUserInfo(userInfo);
                    }
                }
            }
            return users;
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transactionDao.end();
        }
    }

    @Override
    public boolean changeStatusUser(int id) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) userDao);
        try {
            User user = userDao.findEntityById(id);
            if (user.getUserStatus().equals(UserStatus.BLOCKED)) {
                user.setUserStatus(UserStatus.PERMITTED);
            } else {
                user.setUserStatus(UserStatus.BLOCKED);
            }
            userDao.update(user);
            transactionDao.commit();
            return true;
        } catch (DaoException e) {
            transactionDao.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transactionDao.endTransaction();
        }
    }

    private static boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);

        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;

        for (int i = 0; i < hash.length && i < testHash.length; i++) {
            diff |= hash[i] ^ testHash[i];
        }

        return diff == 0;
    }

    private static String generateStrongPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt().getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);

    }

    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    private static byte[] fromHex(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
