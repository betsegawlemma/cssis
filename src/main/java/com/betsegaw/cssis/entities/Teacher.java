package com.betsegaw.cssis.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherId;
    private String staffId;
    private String firstName;
    private String lastName;
    private String subjectSpeciality;
    private Address address;

    @Temporal(TemporalType.DATE)
    private Date hiredDate;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Enrollment> enrollments = new HashSet<>();

    public Teacher addEnrollment(Enrollment enrollment){
        this.enrollments.add(enrollment);
        enrollment.setTeacher(this);
        return this;
    }

    public void removeEnrollment(Enrollment enrollment){
        this.enrollments.remove(enrollment);
        enrollment.setTeacher(null);
    }

}
