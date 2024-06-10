package com.example.ecommerce.modal.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 250, unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "price")
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "shippingUnit")
    private ShippingUnit shippingUnit;


    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Column(name = "quantity")
    private int quantity;
}
