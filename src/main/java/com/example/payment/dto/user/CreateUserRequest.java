package com.example.payment.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateUserRequest {

    private String userId;
    @NotBlank
    @Size(max = 40, message = "UserName length should not be grater than 40 characters")
    private String userName;
    @NotBlank
    @Size(min = 6, max = 20, message = "password length should not be between 6 and 20 characters")
    private String password;
    @NotBlank
    @Size(max = 40, message = "First Name length should not be grater than 40 characters")
    private String firstName;
    private String lastName;
    @NotBlank
    @Size(max = 40, message = "email length should not be grater than 40 characters")
    @Email
    private String email;

    public CreateUserRequest(){}

    public CreateUserRequest(String userId, String userName, String password, String firstName, String lastName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}