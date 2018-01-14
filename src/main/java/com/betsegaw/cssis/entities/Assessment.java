package com.betsegaw.cssis.entities;

import com.betsegaw.cssis.enums.Month;
import com.betsegaw.cssis.enums.Semester;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @NotBlank
    private Course course;
    @NotNull
    private Month month;
    @NotNull
    private String round;
    @NotNull
    @Min(0)
    @Max(100)
    private int outOf;
    @NotNull
    @NotBlank
    @Min(1900)
    private int academicYear;
    @NotNull
    private Semester semester;
    @NotNull
    @Min(0)
    @Max(100)
    private float mark;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
