package by.training.barbershop.controller;

import by.training.barbershop.bean.*;
import by.training.barbershop.dao.impl.TransactionDaoImpl;
import by.training.barbershop.dao.impl.UserDaoImpl;
import by.training.barbershop.service.ServiceFactory;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
//        UserInfoDao userInfoDao = new UserInfoDao();
//        BarbersDao barbersDao = new BarbersDao();
//        TypesDao typesDao = new TypesDao();
//        HaircutDao haircutDao = new HaircutDao();
//        OrdersDao ordersDao = new OrdersDao();
        TransactionDaoImpl transaction = new TransactionDaoImpl();
        transaction.initTransaction(userDao);
//
        try {
            // List<User> users = new ArrayList<>(userDao.findAll());
//            User user = new User();
//            user.setLogin("dima7");
//            user.setPassword("12");
//            String role = "1";
//            user.setRole(Byte.parseByte(role));
//            UserInfo userInfo = new UserInfo();
//            userInfo.setUser(user);
//            userInfo.setName("dima");
//            userInfo.setSurname("garist");
//            userInfo.setPatronymic("sergeevich");
//            userInfo.setEmail("garist300@gmail.com");
//            userInfo.setPhone(+375295004802l);
//            userInfo.setBirthday(Date.valueOf("2000-10-18"));
//            ServiceFactory serviceFactory = ServiceFactory.getInstance();
          //  serviceFactory.getUserServiceImpl().createNewUser(user);
//            List<UserInfo> userInfos = new ArrayList<>(userInfoDao.findAll());
//            System.out.println(users);
//            int i = 0;
//            for (var userInfo : userInfos) {
//                userInfo.getId().setLogin(users.get(i).getLogin());
//                userInfo.getId().setPassword(users.get(i).getPassword());
//                userInfo.getId().setRole(users.get(i).getRole());
//                System.out.println(userInfo);
//                i++;
//            }
//            List<Barber> barbers = new ArrayList<>(barbersDao.findAll());
//            for (var barber : barbers) {
//                System.out.println(barber);
//            }
//            List<Type> types = new ArrayList<>(typesDao.findAll());
//            for (var type : types){
//                System.out.println(type);
//            }
//            List<Haircut> haircuts = new ArrayList<>(haircutDao.findAll());
//            for (var haircut : haircuts){
//                System.out.println(haircut);
//            }
//            List<Order> orders = new ArrayList<>(ordersDao.findAll());
//            for (var order : orders){
//                System.out.println(order);
//            }
            transaction.commit();
        } finally {
            transaction.endTransaction();
        }
    }
}

