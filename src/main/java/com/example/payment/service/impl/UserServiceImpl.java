package com.example.payment.service.impl;

import com.example.payment.dto.user.CreateUserRequest;
import com.example.payment.dto.user.GetUserInfoResponse;
import com.example.payment.dto.user.GetUserResponse;
import com.example.payment.entity.User;
import com.example.payment.exception.RunTimeExceptionPlaceHolder;
import com.example.payment.repository.UserRepository;
import com.example.payment.service.UserService;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public String createUser(CreateUserRequest createUserRequest) {

        if (userRepository.existsByUserName(createUserRequest.getUserName())) {
            throw new RunTimeExceptionPlaceHolder("Username is already taken!!");
        }

        if (userRepository.existsByEmail(createUserRequest.getEmail())) {
            throw new RunTimeExceptionPlaceHolder("Email address already in use!!");
        }

        // encrypt password
        String encryptedPassword = createUserRequest.getPassword();
        try {
            encryptedPassword = hashPassword(createUserRequest.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
        }
        logger.info("Encrypted password:", encryptedPassword);

        User user = new User(createUserRequest.getUserName(), encryptedPassword,
                             createUserRequest.getFirstName(),
                             createUserRequest.getLastName(),
                             createUserRequest.getEmail(),
                             new Date(),
                             new Date());

        User savedUser = userRepository.save(user);
//
//        if (!errorResponse.getErrors().isEmpty()) {
//            throw new SuccessCodeWithErrorResponse(savedUser.getUserId(), errorResponse);
//        }

        return savedUser.getUserId();
    }

    @Override
    public GetUserResponse getUserByUserName(String userName) {
        Optional<User> userNameOrEmailOptional = userRepository
                .findByUserNameOrEmail(userName, userName);
        User userByUserName = userNameOrEmailOptional.orElseThrow(() ->
                new RunTimeExceptionPlaceHolder("UserName or Email doesn't exist!!")
        );

        GetUserResponse user = new GetUserResponse(userByUserName.getUserId(),
                                                   userByUserName.getUserName(),
                                                   userByUserName.getFirstName(),
                                                   userByUserName.getLastName(),
                                                   userByUserName.getEmail());
        return user;
    }

    @Override
    public GetUserResponse getUserByUserId(String userId) {
        Optional<User> userIdOptional = userRepository.findByUserId(userId);
        User userById = userIdOptional.orElseThrow(() ->
                new RunTimeExceptionPlaceHolder("UserName or Email doesn't exist!!")
        );

        GetUserResponse user = new GetUserResponse(userById.getUserId(),
                userById.getUserName(),
                userById.getFirstName(),
                userById.getLastName(),
                userById.getEmail());
        return user;
    }

    @Override
    public GetUserInfoResponse getUserInfo(String userId) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userName = (String) authentication.getPrincipal();

        GetUserResponse userByUserId = getUserByUserId(userId);
//
        GetUserInfoResponse user = new GetUserInfoResponse(
                        userByUserId.getUserId(),
                        userByUserId.getUserName(),
                        userByUserId.getFirstName(),
                        userByUserId.getLastName(),
                        userByUserId.getEmail());
        return user;
    }

    String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return myHash;
    }
}
