package com.pranathi.coursemanagement.service;

import com.pranathi.coursemanagement.dto.request.EnrollmentRequest;
import com.pranathi.coursemanagement.dto.response.EnrollmentResponse;

import java.util.List;

public interface EnrollmentService {

    EnrollmentResponse enrollCourse(EnrollmentRequest request);

    List<EnrollmentResponse> getStudentEnrollments(Long studentId);

}