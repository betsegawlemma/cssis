package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.entities.GradeEnrollment;
import com.betsegaw.cssis.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GradeEnrollmentRepository extends JpaRepository<GradeEnrollment,Long>{
    Set<GradeEnrollment> findByStudent(Student student);
}
