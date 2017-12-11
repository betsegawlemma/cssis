package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherId;
    private String staffId;
    private String firstName;
    private String lastName;
    private String subjectSpeciality;
    private Address address;

    @Temporal(TemporalType.DATE)
    private Date hiredDate;

}
