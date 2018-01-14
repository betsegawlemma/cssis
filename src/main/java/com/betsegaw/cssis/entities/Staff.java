package com.betsegaw.cssis.entities;

import com.betsegaw.cssis.enums.Role;
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
    private String staffId; // Staff Identification Number given by the institute where the staff is working
    @NotNull
    private String firstName;
    private String middleName;
    @NotNull
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private String nationality;
    private Address address;

    @Temporal(TemporalType.DATE)
    private Date hiredDate;

}
