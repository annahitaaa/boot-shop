package com.annahita.bootshop.dto;


import com.annahita.bootshop.validator.Phone;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
public class CustomerDto {

    @NotEmpty
    @Size(min=5,max=30)
    private String customerName;

    @NotEmpty
    @Email
    private String customerEmailAddress;

    @NotEmpty
    @Phone
    private String customerPhoneNumber;

    @NotEmpty
    @Size(min=5,max=30)
    private String username;

    @NotEmpty
    private String password;

    @Valid
    private ShippingAddressDto shippingAddress;

    @Valid
    private BillingAddressDto billingAddress;
}
