package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.entities.GradeType;
import com.betsegaw.cssis.entities.TeacherEnrollment;

import java.util.Set;

public interface TeacherEnrollmentService {
    public Set<TeacherEnrollment> findAll();
    public Set<TeacherEnrollment> findByCourse(Course course);
    public Set<TeacherEnrollment> findByGrade(GradeType grade);
    public TeacherEnrollment findById(Long teacherEnrollmentId);
    public TeacherEnrollment save(TeacherEnrollment teacherEnrollment);
    public void deleteById(Long teacherEnrollmentId);
}
