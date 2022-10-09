package com.itender.service;

import java.util.List;

import com.itender.model.Role;
import com.itender.model.UserApp;

public interface UserService {

    UserApp saveUser(UserApp userApp);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    UserApp getUser(String username);

    List<UserApp> getUsers();

}
