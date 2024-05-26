package com.example.qasbaouiproject.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double totalPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCmd;

    @ManyToMany
    private List<Product> products;

    @OneToOne(mappedBy = "cart")
    private Client client;

    public boolean removeProduct(Product product) {
       return products.remove(product);
    }

    public boolean addProduct(Product product) {
        return products.add(product);
    }
}
