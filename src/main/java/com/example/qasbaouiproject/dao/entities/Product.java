package com.example.qasbaouiproject.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameClient;
    private String name;
    private double price;
    private String description;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    

}

