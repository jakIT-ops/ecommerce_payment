package com.example.payment.service;

import com.example.payment.dto.user.CreateUserRequest;
import com.example.payment.dto.user.GetUserInfoResponse;
import com.example.payment.dto.user.GetUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    String createUser(CreateUserRequest createUserRequest);
    GetUserResponse getUserByUserName(String userName);
    GetUserResponse getUserByUserId(String userId);
    GetUserInfoResponse getUserInfo(String userId);
}
