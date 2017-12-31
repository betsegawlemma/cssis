package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Embeddable
public class StudentStatus {

    @NotNull
    private int academicYear;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private int rank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentStatus that = (StudentStatus) o;

        if (academicYear != that.academicYear) return false;
        if (rank != that.rank) return false;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = academicYear;
        result = 31 * result + status.hashCode();
        result = 31 * result + rank;
        return result;
    }
}
