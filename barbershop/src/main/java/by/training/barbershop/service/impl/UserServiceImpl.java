package by.training.barbershop.service.impl;

import by.training.barbershop.bean.User;
import by.training.barbershop.bean.UserInfo;
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
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.SQLException;


public class UserServiceImpl implements UserService {
    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public User findRegisteredUser(String login, String password) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        transactionDao.initTransaction((AbstractDao) userDao);
        if (login != null && password != null) {
            try {
                return userDao.findUserByLoginAndPassword(login, hashingPassword(password));
            } catch (DaoException | UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException e) {
                throw new ServiceException(e);
            }
        }
        return null;
    }

    @Override
    public boolean addNewUser(UserInfo userInfo) throws ServiceException {
        UserDao userDao = daoFactory.getUserDao();
        UserInfoDao userInfoDao = daoFactory.getUserInfoDao();
        TransactionDao transactionDao = daoFactory.getTransactionDao();
        try {
            if (userInfo != null) {
                transactionDao.initTransaction((AbstractDao) userDao, (AbstractDao) userInfoDao);
                User user = userInfo.getUser();
                String password = user.getPassword();
                user.setPassword(hashingPassword(password));
                userInfo.setUser(user);

                int idUser = userDao.create(user);
                user = userDao.findEntityById(idUser);
                userInfo.setUser(user);
                userInfoDao.create(userInfo);
                transactionDao.commit();
                transactionDao.endTransaction();

                return true;
            }
        } catch (DaoException | NoSuchAlgorithmException | InvalidKeySpecException | UnsupportedEncodingException | SQLException e) {
            transactionDao.rollback();
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public long parseTel(String number) {
        return Long.parseLong(number.replaceAll("\\D", ""));
    }

    private String hashingPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {//попробовать другую шифровку
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        return new String(hash, StandardCharsets.UTF_8);
    }
}
