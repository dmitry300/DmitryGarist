package by.training.barbershop.service;

import by.training.barbershop.bean.Order;
import by.training.barbershop.bean.OrderStatus;
import by.training.barbershop.service.exception.ServiceException;

import java.util.List;

public interface OrderService {
    boolean addOrder(Order order) throws ServiceException;

    List<Order> findAllActiveOrder(boolean active) throws ServiceException;

    List<Order> findOrderByUserId(int userId) throws ServiceException;

    boolean removeOrderById(int orderId) throws ServiceException;

    boolean changeStatusOrder(Order order, OrderStatus orderStatus) throws ServiceException;

    Order findOrderById(int id) throws ServiceException;

    boolean updateOrder(Order order) throws ServiceException;

    List<Order> findActiveOrderByStatus(OrderStatus status, boolean active) throws ServiceException;
}
