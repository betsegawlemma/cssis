package com.betsegaw.cssis.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
