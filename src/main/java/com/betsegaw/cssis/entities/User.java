package com.betsegaw.cssis.entities;


import com.betsegaw.cssis.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String userName;
    @NotNull
    @NotBlank
    private String password;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @NotBlank
    private Role role;
}
