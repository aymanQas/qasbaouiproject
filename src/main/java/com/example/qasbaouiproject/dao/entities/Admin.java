package com.example.qasbaouiproject.dao.entities;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "Admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "admin")
    private List<Order> orders;

}
