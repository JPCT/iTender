package com.iTender.service;

import java.util.List;

import com.iTender.model.Role;
import com.iTender.model.User;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();

}
