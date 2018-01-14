package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Assessment;
import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.entities.Student;
import com.betsegaw.cssis.enums.Month;
import com.betsegaw.cssis.enums.Semester;

import java.util.Set;

public interface AssessmentService {
    public Set<Assessment> findAll();
    public Assessment findById(Long assessmentId);
    public Set<Assessment> findByStudentAndCourseAndAcademicYearAndSemester(Student student, Course course,
                                                                            int academicYear, Semester semester);
    public Set<Assessment> findByAcademicYearAndSemesterAndMonth(int academicYear, Semester semester, Month month);
    public Assessment save(Assessment assessment);
    public void deleteById(Long assessmentId);
}
