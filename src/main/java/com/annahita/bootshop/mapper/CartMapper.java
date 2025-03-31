package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.CartDto;
import com.annahita.bootshop.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    Cart toEntity(CartDto cartDto);
}
