package com.itender.api.request;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String sex;
    private String username;
    private String password;

}
