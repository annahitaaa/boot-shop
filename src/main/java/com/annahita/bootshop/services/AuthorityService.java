package com.annahita.bootshop.services;

import com.annahita.bootshop.entity.Authority;

import java.util.List;

public interface AuthorityService {

    Authority findByType(String type);

    List<Authority> findAll();
}
