package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Embeddable
public class StudentStatus {

    private int academicYear;
    private Status status;
}
