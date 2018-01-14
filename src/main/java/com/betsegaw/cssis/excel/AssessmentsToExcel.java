package com.betsegaw.cssis.excel;

import com.betsegaw.cssis.services.AssessmentServiceImpl;
import com.betsegaw.cssis.services.CourseEnrollmentServiceImpl;

import org.springframework.stereotype.Service;


@Service
public class AssessmentsToExcel {
    
    private final CourseEnrollmentServiceImpl courseEnrollmentService;
    private final AssessmentServiceImpl assessmentService;

    public AssessmentsToExcel(CourseEnrollmentServiceImpl courseEnrollmentService, AssessmentServiceImpl assessmentService) {
        this.courseEnrollmentService = courseEnrollmentService;
        this.assessmentService = assessmentService;
    }

    // TODO: 1/14/18  Wirte to excel student assessment

}
