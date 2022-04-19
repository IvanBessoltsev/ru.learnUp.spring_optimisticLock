package ru.learnup.spring_boot.spring_test_springboot.Service;

import ru.learnup.spring_boot.spring_test_springboot.entity.Order;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrder();

    public Order getOrderById(int id);

    public void saveOrder(Order order);

    public void deleteOrder(int id);
}
