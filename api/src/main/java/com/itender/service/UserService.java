package com.itender.service;

import java.util.List;

import com.itender.model.Role;
import com.itender.model.User;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();

}
