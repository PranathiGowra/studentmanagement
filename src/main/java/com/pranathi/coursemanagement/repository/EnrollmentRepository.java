package com.pranathi.coursemanagement.repository;

import com.pranathi.coursemanagement.entity.Enrollment;
import com.pranathi.coursemanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudent(Student student);

}