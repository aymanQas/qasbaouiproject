package com.example.qasbaouiproject.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateCmd;
    private double totalPrice;

    @ManyToOne
    private Admin admin;

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Product> products;

}
