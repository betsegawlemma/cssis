package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.entities.CourseEnrollment;
import com.betsegaw.cssis.entities.Student;
import com.betsegaw.cssis.enums.Semester;

import java.util.Set;

public interface CourseEnrollmentService {
   public Set<CourseEnrollment> findAll();
   public CourseEnrollment findById(Long courseEnrollmentId);
   public CourseEnrollment save(CourseEnrollment courseEnrollment);
   public Set<CourseEnrollment> findByStudent(Student student);
   public Set<CourseEnrollment> findByStudentAndAcademicYearAndSemester(Student student, int academicYear,
                                                                        Semester semester);
   public Set<CourseEnrollment> findByCourseAndAcademicYearAndSemester(Course course, int academicYear,
                                                                       Semester semester);
   public void deleteById(Long id);
}
