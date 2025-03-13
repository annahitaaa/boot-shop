package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.BillingAddressDto;
import com.annahita.bootshop.entity.BillingAddress;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BillingAddressMapper {
    BillingAddress toEntity(BillingAddressDto billingAddressDto);
}
