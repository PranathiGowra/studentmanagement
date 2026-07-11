package com.pranathi.coursemanagement.controller;

import com.pranathi.coursemanagement.dto.request.LoginRequest;
import com.pranathi.coursemanagement.dto.request.RegisterRequest;
import com.pranathi.coursemanagement.dto.response.ApiResponse;
import com.pranathi.coursemanagement.dto.response.LoginResponse;
import com.pranathi.coursemanagement.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

}