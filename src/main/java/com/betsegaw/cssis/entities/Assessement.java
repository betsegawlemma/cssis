package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Embeddable
public class Assessement {

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
}
