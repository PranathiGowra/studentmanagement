package com.pranathi.coursemanagement.service;

import com.pranathi.coursemanagement.dto.request.CourseRequest;
import com.pranathi.coursemanagement.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse addCourse(CourseRequest request);

    List<CourseResponse> getAllCourses();

    CourseResponse getCourseById(Long id);

    CourseResponse updateCourse(Long id, CourseRequest request);

    void deleteCourse(Long id);
}