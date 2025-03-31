package com.annahita.bootshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends Audit implements Serializable {
    private static final long serialVersionUID = 104L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private double grandTotal;
/*
    @OneToOne(mappedBy = "cart")
    private Customer customer;*/

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItems;

}
