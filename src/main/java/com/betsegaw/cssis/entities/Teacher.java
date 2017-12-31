package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherId;
    private String firstName;
    private String lastName;
    private String nationality;
    private String subjectSpeciality;
    private Address address;

    @Temporal(TemporalType.DATE)
    private Date hiredDate;
}
