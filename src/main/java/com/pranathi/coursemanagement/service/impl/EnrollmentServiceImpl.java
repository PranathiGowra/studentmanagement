package com.pranathi.coursemanagement.service.impl;

import com.pranathi.coursemanagement.dto.request.EnrollmentRequest;
import com.pranathi.coursemanagement.dto.response.EnrollmentResponse;
import com.pranathi.coursemanagement.entity.Course;
import com.pranathi.coursemanagement.entity.Enrollment;
import com.pranathi.coursemanagement.entity.Student;
import com.pranathi.coursemanagement.repository.CourseRepository;
import com.pranathi.coursemanagement.repository.EnrollmentRepository;
import com.pranathi.coursemanagement.repository.StudentRepository;
import com.pranathi.coursemanagement.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public EnrollmentResponse enrollCourse(EnrollmentRequest request) {

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .course(course)
                .enrollmentDate(LocalDate.now())
                .build();

        enrollmentRepository.save(enrollment);

        return EnrollmentResponse.builder()
                .enrollmentId(enrollment.getEnrollmentId())
                .studentName(student.getName())
                .courseTitle(course.getTitle())
                .enrollmentDate(enrollment.getEnrollmentDate().toString())
                .build();
    }

    @Override
    public List<EnrollmentResponse> getStudentEnrollments(Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return enrollmentRepository.findByStudent(student)
                .stream()
                .map(enrollment -> EnrollmentResponse.builder()
                        .enrollmentId(enrollment.getEnrollmentId())
                        .studentName(student.getName())
                        .courseTitle(enrollment.getCourse().getTitle())
                        .enrollmentDate(enrollment.getEnrollmentDate().toString())
                        .build())
                .collect(Collectors.toList());
    }
}