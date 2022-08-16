package com.example.payment.controller;

import com.example.payment.dto.user.CreateUserRequest;
import com.example.payment.dto.user.GetUserInfoResponse;
import com.example.payment.dto.user.GetUserResponse;
import com.example.payment.service.UserService;
import java.net.URI;
import java.util.Optional;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/user")
//  @PreAuthorize("hasAuthority('ADMIN_USER')")
  public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {

    String userId = userService.createUser(createUserRequest);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{userId}")
        .buildAndExpand(userId).toUri();

    return ResponseEntity.created(location).build();
  }

  @GetMapping("/user")
  //@PreAuthorize("hasAuthority('ADMIN_USER')")
  public ResponseEntity<GetUserResponse> getUser(
      @RequestParam("userName") Optional<String> userName
      , @RequestParam("userId") Optional<String> userId) {

    GetUserResponse user = null;
    if (userName.isPresent()) {
      user = userService.getUserByUserName(userName.get());
    } else if (userId.isPresent()) {
      user = userService.getUserByUserId(userId.get());
    }
    return ResponseEntity.ok(user);
  }

  @GetMapping("/userInfo/{userID}")
  public ResponseEntity<GetUserInfoResponse> getUserInfo(@PathVariable("userID") String userId) {
    GetUserInfoResponse userInfo = userService.getUserInfo(userId);
    return new ResponseEntity<>(userInfo, HttpStatus.OK);
  }
}

