package com.annahita.bootshop.dto;


import com.annahita.bootshop.validator.Phone;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
public class CustomerDto extends UserDto {

    @NotEmpty
    @Size(min=5,max=30)
    private String customerName;

    @NotEmpty
    @Email
    private String customerEmailAddress;

    @NotEmpty
    @Phone
    private String customerPhoneNumber;

    @Valid
    private ShippingAddressDto shippingAddressDto;

    @Valid
    private BillingAddressDto billingAddressDto;

/*    @Valid
    private UserDto userDto;*/

//    @Valid
//    private CartDto cartDto;
}
