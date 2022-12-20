package com.itender.api.request;

import lombok.Data;

@Data
public class RoleToUserRequest {

    private String username;
    private String roleName;

}
