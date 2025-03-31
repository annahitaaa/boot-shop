package com.annahita.bootshop.entity;

import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority extends Audit implements Serializable {
    private static final long serialVersionUID = 107L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorityId;

    @NotEmpty
    private String authorityType;

    @ManyToMany(mappedBy = "authoritySet")
    private Set<User> users;
}
