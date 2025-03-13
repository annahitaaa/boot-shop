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
public class User extends Audit implements Serializable {
    private static final long serialVersionUID = 106L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotEmpty
    private String password;

    private boolean enabled;

    @OneToOne(mappedBy = "user")
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_authorities",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "authorityId")
    )
    private Set<Authority> authorities;
}
