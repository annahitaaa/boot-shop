package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.ShippingAddressDto;
import com.annahita.bootshop.entity.ShippingAddress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShippingAddressMapper {

    ShippingAddress toEntity(ShippingAddressDto shippingAddressDto);
}
