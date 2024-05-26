package com.example.qasbaouiproject.dao.repositories;

import com.example.qasbaouiproject.dao.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
