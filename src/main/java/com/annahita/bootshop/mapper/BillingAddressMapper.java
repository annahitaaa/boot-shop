package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.BillingAddressDto;
import com.annahita.bootshop.entity.BillingAddress;
import org.mapstruct.*;

@Mapper
public interface BillingAddressMapper {
    BillingAddress toEntity(BillingAddressDto billingAddressDto);
}
