package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.CartItemDto;
import com.annahita.bootshop.entity.CartItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {CartMapper.class, ProductMapper.class})
public interface CartItemMapper {
    CartItem toEntity(CartItemDto cartItemDto);
}
