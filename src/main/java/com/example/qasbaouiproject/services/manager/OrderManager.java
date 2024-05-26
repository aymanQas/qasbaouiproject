package com.example.qasbaouiproject.services.manager;

import com.example.qasbaouiproject.dao.entities.Order;

import java.util.List;

public interface OrderManager {

    List<Order> getAllOrders();

    Order getOrderById(Long id);
}
