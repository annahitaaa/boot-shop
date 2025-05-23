package com.annahita.bootshop.dto;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;


@Getter
@Setter
public class UserDto {
    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotEmpty
    private String password;

//    @Valid
    private Set<AuthorityDto> authorityDtoSet;
}
