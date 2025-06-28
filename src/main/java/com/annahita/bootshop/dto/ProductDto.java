package com.annahita.bootshop.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
public class ProductDto {

    @NotEmpty(message = "Product name cannot be empty")
    private String productName;

    @NotEmpty(message = "Product brand cannot be empty")
    private String productBrand;

    @NotEmpty(message = "Product model cannot be empty")
    private String productModel;

    @NotEmpty(message = "Product description cannot be empty")
    private String productDescription;

    @NotNull(message = "Product price cannot be null")
    @Range(min = 0, message = "Product price must be non-negative")
    private Double productPrice;

    @NotNull(message = "Unit in stock cannot be null")
    @Range(min = 0, message = "Unit in stock must be non-negative")
    private Double unitInStock;

    @NotNull(message = "Discount cannot be null")
    @Range(min = 0, message = "Discount must be non-negative")
    private Double discount;

    @NotEmpty(message = "ProductStatus model cannot be empty")
    private String productStatus;


    @Setter
    @Getter
    public static class Create extends ProductDto {
        @NotEmpty(message = "ProductCategory model cannot be empty")
        private String productCategory;
    }
    @Getter
    @Setter
    public static class Info extends ProductDto {
        @NotNull
        private Long productId;

        @NotEmpty(message = "ProductCategory model cannot be empty")
        private String productCategory;
    }

    @Getter
    @Setter
    public static class Update extends ProductDto {

    }
    @Setter
    @Getter
    public static class Delete {
        @NotNull
        private Long productId;
    }
}