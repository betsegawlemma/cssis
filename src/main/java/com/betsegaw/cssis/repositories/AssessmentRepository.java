package com.betsegaw.cssis.repositories;

import com.betsegaw.cssis.entities.*;
import com.betsegaw.cssis.enums.Month;
import com.betsegaw.cssis.enums.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment,Long> {
    Set<Assessment> findByStudentAndCourseAndAcademicYearAndSemester(Student student, Course course, int academicYear,
                                                                     Semester semester);

    Set<Assessment> findByAcademicYearAndSemesterAndMonth(int academicYear, Semester semester, Month month);
}
