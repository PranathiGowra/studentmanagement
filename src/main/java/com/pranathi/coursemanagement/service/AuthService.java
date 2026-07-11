package com.pranathi.coursemanagement.service;

import com.pranathi.coursemanagement.dto.request.LoginRequest;
import com.pranathi.coursemanagement.dto.request.RegisterRequest;
import com.pranathi.coursemanagement.dto.response.ApiResponse;
import com.pranathi.coursemanagement.dto.response.LoginResponse;

public interface AuthService {

    ApiResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}