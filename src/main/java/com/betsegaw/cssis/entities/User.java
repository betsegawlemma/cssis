package com.betsegaw.cssis.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    private String phone;
    private String email;
    @NotNull
    private Role role;
}
