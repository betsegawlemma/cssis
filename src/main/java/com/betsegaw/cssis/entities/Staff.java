package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String staffId;
    @NotNull
    private String firstName;
    private String middleName;
    @NotNull
    private String lastName;
    private Role role;
    private Address address;

    @Temporal(TemporalType.DATE)
    private Date hiredDate;

}
