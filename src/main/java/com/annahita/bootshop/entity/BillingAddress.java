package com.annahita.bootshop.entity;


import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillingAddress extends Audit implements Serializable {

    private static final Long serialVersionUID = 103l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billingAddressId;

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

    @OneToOne(mappedBy = "billingAddress")
    private Customer customer;
}
