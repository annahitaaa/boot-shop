package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.UserDto;
import com.annahita.bootshop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses={AuthorityMapper.class, CustomerMapper.class})
public interface UserMapper {
    @Mapping(target = "authoritySet", ignore = true)
    /*@Mapping(target = "customer.user", ignore = true)*/
    User toEntity(UserDto userDto);
}
