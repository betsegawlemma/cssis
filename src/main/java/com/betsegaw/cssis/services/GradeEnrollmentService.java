package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.GradeEnrollment;
import com.betsegaw.cssis.entities.Student;
import com.betsegaw.cssis.enums.Grade;
import com.betsegaw.cssis.enums.Semester;

import java.util.Optional;
import java.util.Set;

public interface GradeEnrollmentService {
    public Set<GradeEnrollment> findAll();
    public Set<GradeEnrollment> findByStudent(Student student);
    public Set<GradeEnrollment> findByGradeAndAcademicYearAndSemester(Grade grade, int academicYear,
                                                               Semester semester);
    public Set<GradeEnrollment> findByGradeAndAcademicYearAndSemesterAndSection(Grade grade, int academicYear,
                                                                         Semester semester, String section);
    public Set<GradeEnrollment> findByStudentAndAcademicYearAndSemester(int academicYear, Semester semester);
    public GradeEnrollment findById(Long gradeEnrollmentId);
    public GradeEnrollment save(GradeEnrollment gradeEnrollment);
    public void deleteById(Long gradeEnrollmentId);
}
