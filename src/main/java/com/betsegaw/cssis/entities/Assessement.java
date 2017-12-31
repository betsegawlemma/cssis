package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Entity
public class Assessement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Course course;
    @NotNull
    private Month month;
    @NotNull
    private String round;
    @NotNull
    private int outOf;
    @NotNull
    private int academicYear;
    @NotNull
    private Semester semester;

    @ManyToMany(mappedBy = "assessments")
    private Set<Student> students;

}
