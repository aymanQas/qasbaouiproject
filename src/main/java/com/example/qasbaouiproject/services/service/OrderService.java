package com.example.qasbaouiproject.services.service;


import com.example.qasbaouiproject.dao.entities.Order;
import com.example.qasbaouiproject.dao.repositories.OrderRepository;
import com.example.qasbaouiproject.services.manager.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderManager {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }


}
