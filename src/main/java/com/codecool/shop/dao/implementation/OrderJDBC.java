package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.model.Order;

import java.util.List;

public class OrderJDBC implements OrderDao {
    private static OrderJDBC instance = null;

    public OrderJDBC() {

    }

    public static OrderJDBC getInstance() {
        if (instance == null) {
            instance = new OrderJDBC();
        }
        return instance;
    }

    @Override
    public void add(Order order) {

    }

    @Override
    public Order find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
