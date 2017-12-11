package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;
    @NotNull
    private String firstName;
    private String middleName;
    @NotNull
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String placeOfBirth;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private String nationality;

    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Lob
    private Byte[] photo;

    private String vision;

    private Address address;

    @ManyToMany
    @JoinTable(name = "student_parent",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id"))
    private Set<Parent> parents = new HashSet<>();

    @ElementCollection
    private Set<StudentStatus> studentStatuses;

    @ManyToMany
    @JoinTable(name = "student_grade",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "grade_id"))
    private Set<Grade> grades = new HashSet<>();



}
