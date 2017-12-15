package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseCode;
    @NotNull
    @Lob
    @NotNull
    private String subject;

    @NotNull
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private GradeGroup gradeGroup;

    @NotNull
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Field field;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Enrollment> enrollments = new HashSet<>();

    public Course addEnrollment(Enrollment enrollment){
        this.enrollments.add(enrollment);
        enrollment.setCourse(this);
        return this;
    }

    public void removeEnrollment(Enrollment enrollment){
        this.enrollments.remove(enrollment);
        enrollment.setCourse(null);
    }


}
