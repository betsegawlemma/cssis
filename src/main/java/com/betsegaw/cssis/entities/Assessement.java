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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assessement that = (Assessement) o;

        if (outOf != that.outOf) return false;
        if (academicYear != that.academicYear) return false;
        if (!course.equals(that.course)) return false;
        if (month != that.month) return false;
        if (!round.equals(that.round)) return false;
        return semester == that.semester;
    }

    @Override
    public int hashCode() {
        int result = course.hashCode();
        result = 31 * result + month.hashCode();
        result = 31 * result + round.hashCode();
        result = 31 * result + outOf;
        result = 31 * result + academicYear;
        result = 31 * result + semester.hashCode();
        return result;
    }
}
