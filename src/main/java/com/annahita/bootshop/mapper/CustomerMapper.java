package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.CustomerDto;
import com.annahita.bootshop.entity.Customer;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        uses = {
                ShippingAddressMapper.class,
                BillingAddressMapper.class,
                UserMapper.class,
//                CartMapper.class,
        })
public interface CustomerMapper {

    CustomerDto toDTO(Customer customer);

    @Mapping(source = "billingAddressDto", target = "billingAddress")
    @Mapping(source = "shippingAddressDto", target = "shippingAddress")
    //@Mapping(source = "userDto", target = "user")
//    @Mapping(source = "cartDto", target ="cart" )
    Customer toEntity(CustomerDto customerDto);
}
