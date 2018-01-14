package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.entities.GradeEnrollment;
import com.betsegaw.cssis.enums.Grade;
import com.betsegaw.cssis.enums.Semester;
import com.betsegaw.cssis.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface GradeEnrollmentRepository extends JpaRepository<GradeEnrollment,Long>{
    Set<GradeEnrollment> findByStudent(Student student);
    Set<GradeEnrollment> findByGradeAndAcademicYearAndSemester(Grade grade, int academicYear,
                                                                   Semester semester);
    Set<GradeEnrollment> findByGradeAndAcademicYearAndSemesterAndSection(Grade grade, int academicYear,
                                                                             Semester semester, String section);
    Set<GradeEnrollment> findByStudentAndAcademicYearAndSemester(int academicYear, Semester semester);
}
