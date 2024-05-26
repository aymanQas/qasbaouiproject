package com.example.qasbaouiproject.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name="Client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @OneToOne
    private Cart cart;

    @OneToMany(mappedBy = "client")
    private List<Order> orders;

}
