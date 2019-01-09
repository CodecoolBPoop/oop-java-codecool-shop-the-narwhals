package com.codecool.shop.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.model.Order;

public class OrderDaoMem implements OrderDao {
    private List<Order> data = new ArrayList<>();
    private static OrderDaoMem instance = null;

    private OrderDaoMem() {}

    public static OrderDaoMem getInstance() {
        if (instance == null) {
            instance = new OrderDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Order order) {
        order.setId(data.size() + 1);
        data.add(order);
    }

    @Override
    public Order find(int id) {
        for (Order item :
                data) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Order> getAll() {
        return data;
    }
}
