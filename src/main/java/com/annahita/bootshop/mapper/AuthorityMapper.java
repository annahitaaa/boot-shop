package com.annahita.bootshop.mapper;

import com.annahita.bootshop.dto.AuthorityDto;
import com.annahita.bootshop.entity.Authority;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorityMapper {
    Authority toEntity(AuthorityDto authorityDto);
}
