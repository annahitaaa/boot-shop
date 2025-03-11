package com.annahita.bootshop.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Getter
@Setter
public class BillingAddressDto {
    @NotEmpty
    private String city;

    @NotEmpty
    private String zipCode;

    @NotEmpty
    private String streetName;

    @NotEmpty
    private String apartmentNumber;

    @NotEmpty
    private String country;

    @NotEmpty
    private String state;
}
