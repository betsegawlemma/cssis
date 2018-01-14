package com.betsegaw.cssis.entities;

import com.betsegaw.cssis.enums.Grade;
import com.betsegaw.cssis.enums.Semester;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class GradeEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Grade grade;
    @NotNull
    private String section;
    @NotNull
    @Min(1900)
    private int academicYear;
    @NotNull
    private Semester semester;
    @NotNull
    @ManyToOne
    private Student student;

}
