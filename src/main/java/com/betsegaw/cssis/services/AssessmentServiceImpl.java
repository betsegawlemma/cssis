package com.betsegaw.cssis.services;

import com.betsegaw.cssis.entities.Assessment;
import com.betsegaw.cssis.entities.Course;
import com.betsegaw.cssis.entities.Student;
import com.betsegaw.cssis.enums.Month;
import com.betsegaw.cssis.enums.Semester;
import com.betsegaw.cssis.exceptions.NotFoundException;
import com.betsegaw.cssis.repositories.AssessmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentRepository assessmentRepository;


    public AssessmentServiceImpl(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    @Override
    public Set<Assessment> findAll() {
        Set<Assessment> assessments = new HashSet<>();
        assessmentRepository.findAll().iterator().forEachRemaining(assessments::add);
        return assessments;
    }

    @Override
    public Assessment findById(Long assessmentId) {
        Optional<Assessment> assessmentOptional = assessmentRepository.findById(assessmentId);
        if(!assessmentOptional.isPresent()){
            throw new NotFoundException("Assessment Not Found. For ID value: " + assessmentId.toString());
        }
        return assessmentOptional.get();
    }

    @Override
    public Set<Assessment> findByStudentAndCourseAndAcademicYearAndSemester(Student student, Course course,
                                                                            int academicYear, Semester semester) {

        Set<Assessment> assessments = new HashSet<>();
        assessmentRepository.findByStudentAndCourseAndAcademicYearAndSemester(student,course,academicYear,semester)
                .iterator().forEachRemaining(assessments::add);
        return assessments;
    }

    @Override
    public Set<Assessment> findByAcademicYearAndSemesterAndMonth(int academicYear, Semester semester, Month month) {
        Set<Assessment> assessments = new HashSet<>();
        assessmentRepository.findByAcademicYearAndSemesterAndMonth(academicYear,semester,month)
                .iterator().forEachRemaining(assessments::add);
        return assessments;
    }

    @Override
    public Assessment save(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    @Override
    public void deleteById(Long assessmentId) {
        assessmentRepository.deleteById(assessmentId);
    }
}
