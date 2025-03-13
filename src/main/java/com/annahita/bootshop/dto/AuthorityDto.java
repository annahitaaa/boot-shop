package com.annahita.bootshop.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorityDto {

    @NotEmpty
    private String authorityType;
}
