package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Student student;
    @NotNull
    @ManyToOne
    private Course course;
    @NotNull
    @ManyToOne
    private Grade grade;
    @NotNull
    @ManyToOne
    private Teacher teacher;

    transient private float mark;
}
