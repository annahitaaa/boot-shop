package com.annahita.bootshop.repository;

import com.annahita.bootshop.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByAuthorityType(String type);
}
