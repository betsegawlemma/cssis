package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseCode;
    @Lob
    @NotNull
    private String subject;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private GradeGroup gradeGroup;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Field field;

}
