package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.CustomerDto;
import com.annahita.bootshop.entity.Customer;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        uses = {
                ShippingAddressMapper.class,
                BillingAddressMapper.class,
                UserMapper.class
        })
public interface CustomerMapper {


    CustomerDto toDTO(Customer customer);

    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "shippingAddress.customer", ignore = true)
    @Mapping(target = "billingAddress.customer", ignore = true)
    Customer toEntity(CustomerDto customerDto);
}
