package com.annahita.bootshop.dto;

import com.annahita.bootshop.entity.Cart;
import com.annahita.bootshop.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDto {

    private double totalPrice;
    private int quantity;
    private Cart cart;
    private Product product;
}
