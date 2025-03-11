package com.annahita.bootshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends Audit implements Serializable {
    private static final long serialVersionUID = 104L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne(mappedBy = "cart")
    private Customer customer;

//    @OneToMany(mappedBy = "cart")
//    private List<CartItem> cartItems;

    private double grandTotal;



}
