package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Enrollment {

   @EmbeddedId
   EnrollmentId id;

    @NotNull
    @ManyToOne
    @MapsId("studetId")
    private Student student;
    @NotNull
    @ManyToOne
    @MapsId("courseId")
    private Course course;
    @NotNull
    @ManyToOne
    @MapsId("gradeId")
    private Grade grade;
    @ManyToOne
    @MapsId("teacherId")
    private Teacher teacher;

    transient private float mark;

    public Enrollment() {
    }

    public Enrollment(@NotNull Student student, @NotNull Course course, @NotNull Grade grade, @NotNull Teacher teacher, float mark) {
        this.id = new EnrollmentId(student.getId(),course.getId(),grade.getId(),teacher.getId());
        this.student = student;
        this.course = course;
        this.grade = grade;
        this.teacher = teacher;
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enrollment that = (Enrollment) o;

        if (Float.compare(that.mark, mark) != 0) return false;
        if (!id.equals(that.id)) return false;
        if (!student.equals(that.student)) return false;
        if (!course.equals(that.course)) return false;
        if (!grade.equals(that.grade)) return false;
        return teacher.equals(that.teacher);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + student.hashCode();
        result = 31 * result + course.hashCode();
        result = 31 * result + grade.hashCode();
        result = 31 * result + teacher.hashCode();
        result = 31 * result + (mark != +0.0f ? Float.floatToIntBits(mark) : 0);
        return result;
    }
}
