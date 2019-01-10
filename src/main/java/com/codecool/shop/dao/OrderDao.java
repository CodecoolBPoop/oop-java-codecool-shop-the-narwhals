package com.codecool.shop.dao;

import java.util.List;
import com.codecool.shop.model.Order;

public interface OrderDao {
    void add(Order order);
    Order find(int id);
    void remove(int id);

    List<Order> getAll();

}
