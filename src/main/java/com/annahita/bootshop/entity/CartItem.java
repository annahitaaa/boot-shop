package com.annahita.bootshop.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class CartItem extends Audit implements Serializable {
    private static final long serialVersionUID = 108L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    private double totalPrice;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="cartId")
    private Cart cart;


    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

}
