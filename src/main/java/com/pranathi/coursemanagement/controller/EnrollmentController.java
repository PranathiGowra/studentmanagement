package com.pranathi.coursemanagement.controller;

import com.pranathi.coursemanagement.dto.request.EnrollmentRequest;
import com.pranathi.coursemanagement.dto.response.EnrollmentResponse;
import com.pranathi.coursemanagement.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public EnrollmentResponse enroll(@RequestBody EnrollmentRequest request) {
        return enrollmentService.enrollCourse(request);
    }

    @GetMapping("/student/{studentId}")
    public List<EnrollmentResponse> getEnrollments(@PathVariable Long studentId) {
        return enrollmentService.getStudentEnrollments(studentId);
    }
}