package by.training.barbershop.service.impl;

import by.training.barbershop.bean.User;
import by.training.barbershop.bean.UserInfo;
import by.training.barbershop.bean.UserRole;
import by.training.barbershop.bean.UserStatus;
import by.training.barbershop.dao.Transaction;
import by.training.barbershop.dao.UserDao;
import by.training.barbershop.dao.UserInfoDao;
import by.training.barbershop.dao.exception.DaoException;
import by.training.barbershop.dao.exception.DatabaseConnectionException;
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
import java.util.Arrays;
import java.util.List;


public class UserServiceImpl implements UserService {
    private static final int ITEMS_ON_PAGE_COUNT = 4;
    private static final int MIN_PAGE_COUNT = 1;

    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private final Transaction transaction = daoFactory.getTransactionDao();

    @Override
    public User findRegisteredUser(String login, String password) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        if (login == null || password == null) {
            return null;
        }
        try {
            transaction.initTransaction((AbstractDao) userDao, (AbstractDao) userInfoDao);
            User user = userDao.findUserByLogin(login);
            UserInfo userInfo = userInfoDao.findEntityById(user.getId());
            user.setUserInfo(userInfo);
            transaction.commit();
            if (validatePassword(password, user.getPassword())) {
                return user;
            } else {
                return null;
            }
        } catch (DaoException | NoSuchAlgorithmException | InvalidKeySpecException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public List<User> findUsersByPage(int pageNumber) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        try {
            transaction.initTransaction((AbstractDao) userDao, (AbstractDao) userInfoDao);
            List<User> users = userDao.findAll();
            List<UserInfo> userInfos = userInfoDao.findAll();
            transaction.commit();
            users.removeIf(admin -> admin.getRole().equals(UserRole.ADMIN));
            for (var user : users) {
                for (var userInfo : userInfos) {
                    if (user.getId() == userInfo.getId()) {
                        user.setUserInfo(userInfo);
                    }
                }
            }
            int fromIndex = (pageNumber - 1) * ITEMS_ON_PAGE_COUNT;
            int toIndex = fromIndex + ITEMS_ON_PAGE_COUNT;
            while (toIndex > users.size()) {
                toIndex = checkToIndex(toIndex, users);
            }
            if (fromIndex == toIndex) {
                users.subList(0, toIndex).clear();
            } else {
                users = users.subList(fromIndex, toIndex);
            }
            return users;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public int calcPagesCountForUsers(int usersCount) {
        int result = (int) Math.ceil((double) usersCount / ITEMS_ON_PAGE_COUNT);
        return result != 0 ? result : MIN_PAGE_COUNT;
    }

    private int checkToIndex(int toIndex, List<User> users) {
        if (toIndex > users.size()) {
            return --toIndex;
        }
        return 0;
    }

    @Override
    public boolean addNewUser(User user) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        try {
            transaction.initTransaction((AbstractDao) userDao, (AbstractDao) userInfoDao);
            if (user != null) {
                String password = user.getPassword();
                user.setPassword(generateStrongPasswordHash(password));
                transaction.commit();
                UserInfo userInfo = user.getUserInfo();
                int idUser = userDao.create(user);
                userInfo.setId(idUser);
                userInfoDao.create(userInfo);

                transaction.commit();
                return true;
            }
        } catch (DaoException | NoSuchAlgorithmException | InvalidKeySpecException | SQLException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        return false;
    }

    @Override
    public User findUserById(int id) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        try {
            transaction.initTransaction((AbstractDao) userDao);
            User user = userDao.findEntityById(id);
            transaction.commit();
            return user;
        } catch (DaoException | DatabaseConnectionException e) {

            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public boolean updateUser(User user) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        try {
            transaction.initTransaction((AbstractDao) userDao, (AbstractDao) userInfoDao);
            if (user != null) {
                String password = user.getPassword();
                String passwordFromDb = userDao.findEntityById(user.getId()).getPassword();
                if (!password.equals(passwordFromDb)) {
                    user.setPassword(generateStrongPasswordHash(password));
                }
                userInfoDao.update(user.getUserInfo());
                userDao.update(user);
                transaction.commit();
                return true;
            }
        } catch (DaoException | NoSuchAlgorithmException | InvalidKeySpecException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e);
        } finally {
            transaction.endTransaction();
        }
        return false;
    }

    @Override
    public boolean isLoginFreeForNewUser(String login) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        try {
            transaction.initTransaction((AbstractDao) userDao);
            return userDao.findUserByLogin(login) != null;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public List<User> findAllUser() throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        try {
            transaction.initTransaction((AbstractDao) userDao, (AbstractDao) userInfoDao);
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
            transaction.commit();
            return users;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transaction.endTransaction();
        }
    }

    @Override
    public boolean changeStatusUser(int id) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        try {
            transaction.initTransaction((AbstractDao) userDao);
            User user = userDao.findEntityById(id);
            if (user.getUserStatus().equals(UserStatus.BLOCKED)) {
                user.setUserStatus(UserStatus.PERMITTED);
            } else {
                user.setUserStatus(UserStatus.BLOCKED);
            }
            userDao.update(user);
            transaction.commit();
            return true;
        } catch (DaoException | DatabaseConnectionException e) {
            transaction.rollback();
            throw new ServiceException(e.getMessage());
        } finally {
            transaction.endTransaction();
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
        return Arrays.toString(salt);
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
