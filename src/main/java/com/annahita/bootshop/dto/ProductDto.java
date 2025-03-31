package com.annahita.bootshop.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
public class ProductDto {

    @NotEmpty
    private String productName;

    @NotEmpty
    private String productBrand;

    @NotEmpty
    private String productModel;

    @NotEmpty
    private String productDescription;

    @NotNull
    @Range(min = 0)
    private Double productPrice;

    @NotNull
    @Range(min = 0)
    private Double unitInStock;

    @NotNull
    @Range(min = 0)
    private Double discount;

    private String productStatus;
    private String productCategory;

}
