package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.GradeEnrollment;
import com.betsegaw.cssis.entities.Student;

import java.util.Set;

public interface GradeEnrollmentService {
    public Set<GradeEnrollment> findAll();
    public Set<GradeEnrollment> findByStudent(Student student);
    public GradeEnrollment findById(Long gradeEnrollmentId);
    public GradeEnrollment save(GradeEnrollment gradeEnrollment);
    public void deleteById(Long gradeEnrollmentId);
}
