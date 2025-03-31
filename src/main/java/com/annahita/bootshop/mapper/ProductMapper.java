package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.ProductDto;
import com.annahita.bootshop.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDto productDto);
}
