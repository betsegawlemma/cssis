package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.entities.TeacherEnrollment;
import com.betsegaw.cssis.enums.Grade;
import com.betsegaw.cssis.enums.Semester;
import com.betsegaw.cssis.exceptions.NotFoundException;
import com.betsegaw.cssis.repositories.TeacherEnrollmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class TeacherEnrollmentServiceImpl implements TeacherEnrollmentService{
    private final TeacherEnrollmentRepository teacherEnrollmentRepository;

    public TeacherEnrollmentServiceImpl(TeacherEnrollmentRepository teacherEnrollmentRepository) {
        this.teacherEnrollmentRepository = teacherEnrollmentRepository;
    }

    @Override
    public Set<TeacherEnrollment> findAll() {
        Set<TeacherEnrollment> teacherEnrollments = new HashSet<>();
        teacherEnrollmentRepository.findAll().iterator().forEachRemaining(teacherEnrollments::add);
        return teacherEnrollments;
    }

    @Override
    public Set<TeacherEnrollment> findByCourse(Course course) {
        Set<TeacherEnrollment> teacherEnrollments = new HashSet<>();
        teacherEnrollmentRepository.findByCourse(course).iterator().forEachRemaining(teacherEnrollments::add);
        return teacherEnrollments;
    }

    @Override
    public Set<TeacherEnrollment> findByGradeAndAcademicYearAndSemester(Grade grade, int academicYear, Semester semester) {
        Set<TeacherEnrollment> teacherEnrollments = new HashSet<>();
        teacherEnrollmentRepository.findByGradeAndAcademicYearAndSemester(grade,academicYear,semester).iterator()
                .forEachRemaining(teacherEnrollments::add);
        return teacherEnrollments;
    }

    @Override
    public TeacherEnrollment findById(Long teacherEnrollmentId) {
        Optional<TeacherEnrollment> teacherEnrollmentOptional = teacherEnrollmentRepository.findById(teacherEnrollmentId);
        if(!teacherEnrollmentOptional.isPresent()){
            throw new NotFoundException("TeacherEnrollment Not Found. For Id Value: " + teacherEnrollmentId.toString());
        }
        return teacherEnrollmentOptional.get();
    }

    @Override
    public TeacherEnrollment save(TeacherEnrollment teacherEnrollment) {
        return teacherEnrollmentRepository.save(teacherEnrollment);
    }

    @Override
    public void deleteById(Long teacherEnrollmentId) {
       teacherEnrollmentRepository.deleteById(teacherEnrollmentId);
    }
}
