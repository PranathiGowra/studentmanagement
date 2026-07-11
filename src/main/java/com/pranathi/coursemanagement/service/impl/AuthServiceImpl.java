package com.pranathi.coursemanagement.service.impl;

import com.pranathi.coursemanagement.dto.request.LoginRequest;
import com.pranathi.coursemanagement.dto.request.RegisterRequest;
import com.pranathi.coursemanagement.dto.response.ApiResponse;
import com.pranathi.coursemanagement.dto.response.LoginResponse;
import com.pranathi.coursemanagement.entity.Role;
import com.pranathi.coursemanagement.entity.Student;
import com.pranathi.coursemanagement.repository.StudentRepository;
import com.pranathi.coursemanagement.security.JwtService;
import com.pranathi.coursemanagement.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public ApiResponse register(RegisterRequest request) {

        if (studentRepository.existsByEmail(request.getEmail())) {
            return new ApiResponse("Email already exists");
        }

        Student student = Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.STUDENT)
                .build();

        studentRepository.save(student);

        return new ApiResponse("Registration Successful");

    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Student student = studentRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), student.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(student.getEmail());

        return new LoginResponse(
                token,
                "Login Successful",
                student.getRole().name()
        );
    }
}