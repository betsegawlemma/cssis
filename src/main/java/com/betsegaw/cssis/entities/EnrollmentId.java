package com.betsegaw.cssis.entities;


import lombok.Getter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
public class EnrollmentId implements Serializable{

   private Long studentId;
   private Long courseId;
   private Long gradeId;
   private Long teacherId;

    public EnrollmentId() {
    }

    public EnrollmentId(Long studentId, Long courseId, Long gradeId, Long teacherId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.gradeId = gradeId;
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnrollmentId that = (EnrollmentId) o;

        if (!studentId.equals(that.studentId)) return false;
        if (!courseId.equals(that.courseId)) return false;
        if (!gradeId.equals(that.gradeId)) return false;
        return teacherId.equals(that.teacherId);
    }

    @Override
    public int hashCode() {
        int result = studentId.hashCode();
        result = 31 * result + courseId.hashCode();
        result = 31 * result + gradeId.hashCode();
        result = 31 * result + teacherId.hashCode();
        return result;
    }
}
