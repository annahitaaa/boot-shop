package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.UserDto;
import com.annahita.bootshop.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses={AuthorityMapper.class})
public interface UserMapper {
    User toEntity(UserDto userDto);
}
