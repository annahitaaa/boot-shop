package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.CustomerDto;
import com.annahita.bootshop.entity.Customer;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ShippingAddressMapper.class, BillingAddressMapper.class})
public interface  CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto toDTO(Customer customer);

    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "shippingAddress.customer", ignore = true)
    @Mapping(target = "billingAddress.customer", ignore = true)
    Customer toEntity(CustomerDto customerDto);
}
