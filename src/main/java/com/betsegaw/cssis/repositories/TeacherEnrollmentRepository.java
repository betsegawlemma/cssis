package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.enums.Grade;
import com.betsegaw.cssis.enums.Semester;
import com.betsegaw.cssis.entities.TeacherEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TeacherEnrollmentRepository extends JpaRepository<TeacherEnrollment,Long> {
    Set<TeacherEnrollment> findByGradeAndAcademicYearAndSemester(Grade grade, int academicYear, Semester semester);
    Set<TeacherEnrollment> findByCourse(Course course);
}
