package com.annahita.bootshop.services.impl;

import com.annahita.bootshop.entity.Authority;
import com.annahita.bootshop.repository.AuthorityRepository;
import com.annahita.bootshop.services.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Override
    @Transactional
    public Authority findByType(String type) {
        return authorityRepository.findByAuthorityType(type);
    }

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }
}
