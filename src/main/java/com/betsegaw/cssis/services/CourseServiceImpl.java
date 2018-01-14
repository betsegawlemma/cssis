package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.enums.GradeGroup;
import com.betsegaw.cssis.exceptions.NotFoundException;
import com.betsegaw.cssis.repositories.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Set<Course> findAll() {
        Set<Course> courses = new HashSet<>();
        courseRepository.findAll().iterator().forEachRemaining(courses::add);
        return courses;
    }

    @Override
    public Course findById(Long courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if(!courseOptional.isPresent()){
            throw new NotFoundException("Course Not Found. For ID value:" + courseId.toString());
        }
        return courseOptional.get();
    }

    @Override
    public Course findByCourseCode(String courseCode) {
        Optional<Course> courseOptional = courseRepository.findByCourseCode(courseCode);
        if(!courseOptional.isPresent()){
            throw new NotFoundException("Course Not Found. For Course Code value:" + courseCode.toString());
        }
        return courseOptional.get();
    }

    @Override
    public Set<Course> findBySubject(String subject) {
       Set<Course> courses = new HashSet<>();
       courseRepository.findBySubject(subject).iterator().forEachRemaining(courses::add);
       return courses;
    }

    @Override
    public Set<Course> findByGradeGroup(GradeGroup gradeGroup) {
        Set<Course> courses = new HashSet<>();
        courseRepository.findByGradeGroup(gradeGroup).iterator().forEachRemaining(courses::add);
        return courses;
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
