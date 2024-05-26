package com.example.qasbaouiproject.dao.repositories;

import com.example.qasbaouiproject.dao.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
