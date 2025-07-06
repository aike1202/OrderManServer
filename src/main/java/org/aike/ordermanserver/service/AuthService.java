package org.aike.ordermanserver.service;

import org.aike.ordermanserver.dto.LoginRequest;
import org.aike.ordermanserver.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}

