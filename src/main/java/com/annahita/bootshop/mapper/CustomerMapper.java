package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.CustomerDto;
import com.annahita.bootshop.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface  CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto toDTO(Customer customer);

    Customer toEntity(CustomerDto customerDto);
}
