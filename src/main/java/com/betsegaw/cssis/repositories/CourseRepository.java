package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.enums.GradeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

    Optional<Course> findByCourseCode(String courseCode);
    Set<Course> findBySubject(String subject);
    Set<Course> findByGradeGroup(GradeGroup gradeGroup);
}
