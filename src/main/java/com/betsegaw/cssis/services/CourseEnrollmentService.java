package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.CourseEnrollment;
import com.betsegaw.cssis.entities.Student;

import java.util.Set;

public interface CourseEnrollmentService {
   public Set<CourseEnrollment> findAll();
   public CourseEnrollment findById(Long courseEnrollmentId);
   public CourseEnrollment save(CourseEnrollment courseEnrollment);
   public Set<CourseEnrollment> findByStudent(Student student);
   public void deleteById(Long id);
}
