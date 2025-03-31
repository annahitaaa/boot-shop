package com.annahita.bootshop.entity;


import com.annahita.bootshop.validator.Phone;
import lombok.*;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "TBL_CUSTOMER")
@PrimaryKeyJoinColumn(name = "userId")
public class Customer extends User implements Serializable {

    private static final Long serialVersionUID = 101l;

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;*/

    @NotEmpty
    @Size(min=5,max=30)
    private String customerName;

    @NotEmpty
    @Email
    private String customerEmailAddress;

    @NotEmpty
    @Phone
    private String customerPhoneNumber;

/*    //@Valid
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;*/

    //@Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    //@Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

/*    @Valid
    @OneToOne
    @JoinColumn(name="cartId")
    private Cart cart;*/

}
