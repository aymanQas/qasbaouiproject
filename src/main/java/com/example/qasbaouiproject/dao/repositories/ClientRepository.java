package com.example.qasbaouiproject.dao.repositories;

import com.example.qasbaouiproject.dao.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByUsername(String username);
}
