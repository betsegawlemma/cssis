package com.betsegaw.cssis.entities;

import com.betsegaw.cssis.enums.Semester;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class CourseEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Student student;
    @NotNull
    @ManyToOne
    private Course course;

    private int academicYear;

    private Semester semester;

    private float totalMark;

}
