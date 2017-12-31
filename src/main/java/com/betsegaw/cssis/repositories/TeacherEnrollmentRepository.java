package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.entities.GradeType;
import com.betsegaw.cssis.entities.TeacherEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TeacherEnrollmentRepository extends JpaRepository<TeacherEnrollment,Long> {
    Set<TeacherEnrollment> findByGrade(GradeType grade);
    Set<TeacherEnrollment> findByCourse(Course course);
}
