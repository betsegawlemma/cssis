package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.entities.CourseEnrollment;
import com.betsegaw.cssis.enums.Semester;
import com.betsegaw.cssis.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment,Long> {
    Set<CourseEnrollment> findByStudent(Student student);
    Set<CourseEnrollment> findByStudentAndAcademicYearAndSemester(Student student, int academicYear, Semester semester);
    Set<CourseEnrollment> findByCourseAndAcademicYearAndSemester(Course course, int academicYear, Semester semester);
}
