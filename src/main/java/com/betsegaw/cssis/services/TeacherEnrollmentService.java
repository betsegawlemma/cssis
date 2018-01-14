package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.enums.Grade;
import com.betsegaw.cssis.entities.TeacherEnrollment;
import com.betsegaw.cssis.enums.Semester;

import java.util.Set;

public interface TeacherEnrollmentService {
    public Set<TeacherEnrollment> findAll();
    public Set<TeacherEnrollment> findByCourse(Course course);
    public Set<TeacherEnrollment> findByGradeAndAcademicYearAndSemester(Grade grade, int academicYear,
                                                                            Semester semester);
    public TeacherEnrollment findById(Long teacherEnrollmentId);
    public TeacherEnrollment save(TeacherEnrollment teacherEnrollment);
    public void deleteById(Long teacherEnrollmentId);
}
