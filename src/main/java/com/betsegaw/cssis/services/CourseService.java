package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.enums.GradeGroup;

import java.util.Set;

public interface CourseService {
    public Set<Course> findAll();
    public Course findById(Long courseId);
    public Course findByCourseCode(String courseCode);
    public Set<Course> findBySubject(String subject);
    public Set<Course> findByGradeGroup(GradeGroup gradeGroup);
    public Course save(Course course);
    public void deleteById(Long courseId);
}
