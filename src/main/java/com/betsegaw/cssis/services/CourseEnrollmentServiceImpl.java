package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.entities.CourseEnrollment;
import com.betsegaw.cssis.entities.Student;
import com.betsegaw.cssis.enums.Semester;
import com.betsegaw.cssis.exceptions.NotFoundException;
import com.betsegaw.cssis.repositories.CourseEnrollmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class CourseEnrollmentServiceImpl implements CourseEnrollmentService {

    private final CourseEnrollmentRepository courseEnrollmentRepository;

    public CourseEnrollmentServiceImpl(CourseEnrollmentRepository courseEnrollmentRepository) {
        this.courseEnrollmentRepository = courseEnrollmentRepository;
    }

    @Override
    public Set<CourseEnrollment> findAll() {
        Set<CourseEnrollment> courseEnrollments = new HashSet<>();
        courseEnrollmentRepository.findAll().iterator().forEachRemaining(courseEnrollments::add);
        return courseEnrollments;
    }

    @Override
    public CourseEnrollment findById(Long courseEnrollmentId) {
        Optional<CourseEnrollment> courseEnrollmentOptional = courseEnrollmentRepository.findById(courseEnrollmentId);
        if(!courseEnrollmentOptional.isPresent()){
            throw new NotFoundException("CourseEnrollment Not Found. For ID value: "+courseEnrollmentId);
        }
        return courseEnrollmentOptional.get();
    }

    @Override
    public CourseEnrollment save(CourseEnrollment courseEnrollment) {
        return courseEnrollmentRepository.save(courseEnrollment);
    }

    @Override
    public Set<CourseEnrollment> findByStudent(Student student) {
        Set<CourseEnrollment> courseEnrollments = new HashSet<>();
        courseEnrollmentRepository.findByStudent(student).iterator().forEachRemaining(courseEnrollments::add);
        return courseEnrollments;
    }

    @Override
    public Set<CourseEnrollment> findByStudentAndAcademicYearAndSemester(Student student, int academicYear,
                                                                         Semester semester) {

        Set<CourseEnrollment> courseEnrollments = new HashSet<>();
        courseEnrollmentRepository.findByStudentAndAcademicYearAndSemester(student,academicYear,semester)
                .iterator().forEachRemaining(courseEnrollments::add);
        return courseEnrollments;
    }

    @Override
    public Set<CourseEnrollment> findByCourseAndAcademicYearAndSemester(Course course, int academicYear,

                                                                        Semester semester) {
        Set<CourseEnrollment> courseEnrollments = new HashSet<>();
        courseEnrollmentRepository.findByCourseAndAcademicYearAndSemester(course,academicYear,semester);
        return courseEnrollments;
    }

    @Override
    public void deleteById(Long id) {
         courseEnrollmentRepository.deleteById(id);
    }
}
