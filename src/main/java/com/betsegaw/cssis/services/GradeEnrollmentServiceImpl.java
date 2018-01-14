package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.GradeEnrollment;
import com.betsegaw.cssis.entities.Student;
import com.betsegaw.cssis.enums.Grade;
import com.betsegaw.cssis.enums.Semester;
import com.betsegaw.cssis.exceptions.NotFoundException;
import com.betsegaw.cssis.repositories.GradeEnrollmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class GradeEnrollmentServiceImpl implements GradeEnrollmentService{
    private final GradeEnrollmentRepository gradeEnrollmentRepository;

    public GradeEnrollmentServiceImpl(GradeEnrollmentRepository gradeEnrollmentRepository) {
        this.gradeEnrollmentRepository = gradeEnrollmentRepository;
    }

    @Override
    public Set<GradeEnrollment> findAll() {
        Set<GradeEnrollment> gradeEnrollments = new HashSet<>();
        gradeEnrollmentRepository.findAll().iterator().forEachRemaining(gradeEnrollments::add);
        return gradeEnrollments;
    }

    @Override
    public Set<GradeEnrollment> findByStudent(Student student) {
        Set<GradeEnrollment> gradeEnrollments = new HashSet<>();
        gradeEnrollmentRepository.findByStudent(student).iterator().forEachRemaining(gradeEnrollments::add);
        return gradeEnrollments;
    }

    @Override
    public Set<GradeEnrollment> findByGradeAndAcademicYearAndSemester(Grade grade, int academicYear,
                                                                      Semester semester) {
        Set<GradeEnrollment> gradeEnrollments = new HashSet<>();
        gradeEnrollmentRepository.findByGradeAndAcademicYearAndSemester(grade,academicYear,semester)
                .iterator().forEachRemaining(gradeEnrollments::add);
        return gradeEnrollments;
    }

    @Override
    public Set<GradeEnrollment> findByGradeAndAcademicYearAndSemesterAndSection(Grade grade, int academicYear,
                                                                                Semester semester, String section) {
        Set<GradeEnrollment> gradeEnrollments = new HashSet<>();
        gradeEnrollmentRepository.findByGradeAndAcademicYearAndSemesterAndSection(grade,academicYear,semester,section)
                .iterator().forEachRemaining(gradeEnrollments::add);
        return gradeEnrollments;
    }

    @Override
    public Set<GradeEnrollment> findByStudentAndAcademicYearAndSemester(int academicYear, Semester semester) {
        Set<GradeEnrollment> gradeEnrollments = new HashSet<>();
        gradeEnrollmentRepository.findByStudentAndAcademicYearAndSemester(academicYear,semester).iterator()
                .forEachRemaining(gradeEnrollments::add);
        return gradeEnrollments;
    }

    @Override
    public GradeEnrollment findById(Long gradeEnrollmentId) {
        Optional<GradeEnrollment> gradeEnrollmentOptional = gradeEnrollmentRepository.findById(gradeEnrollmentId);
        if(!gradeEnrollmentOptional.isPresent()){
            throw new NotFoundException("GradeEnrollment Not Found. For Id Value: " + gradeEnrollmentId.toString());
        }
        return gradeEnrollmentOptional.get();
    }

    @Override
    public GradeEnrollment save(GradeEnrollment gradeEnrollment) {
        return gradeEnrollmentRepository.save(gradeEnrollment);
    }

    @Override
    public void deleteById(Long gradeEnrollmentId) {
         gradeEnrollmentRepository.deleteById(gradeEnrollmentId);
    }
}
