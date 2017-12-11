package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Embeddable
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private GradeType gradeType;
    @NotNull
    private String section;
    @NotNull
    private int academicYear;
    @NotNull
    @ManyToMany(mappedBy = "grades")
    Set<Student> students;

}
