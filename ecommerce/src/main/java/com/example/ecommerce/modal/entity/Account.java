package com.example.ecommerce.modal.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "`Account`")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String username;

    @Column(name = "Role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "password", length = 100, nullable = false)
    private String password;
}
