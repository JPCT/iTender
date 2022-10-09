package com.itender.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itender.model.Role;
import com.itender.model.UserApp;
import com.itender.repository.RoleRepository;
import com.itender.repository.UserRepository;
import com.itender.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserApp> userOptional = userRepository.findByUsername(username);

        if (!userOptional.isPresent()) {
            log.error("UserApp not found in the database");
            throw new UsernameNotFoundException("UserApp not found in the database");
        } else {
            log.info("UserApp found in the database: {}", username);
        }

        UserApp userApp = userOptional.get();

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userApp.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

        return new User(userApp.getUsername(), userApp.getPassword(), authorities);
    }

    @Override
    public UserApp saveUser(UserApp userApp) {
        log.info("Saving new userApp {} to the database", userApp.getUsername());
        return userRepository.save(userApp);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        Optional<UserApp> userOptional = userRepository.findByUsername(username);
        Optional<Role> roleOptional = roleRepository.findByName(roleName);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            UserApp userApp = userOptional.get();
            Role role = roleOptional.get();
            userApp.getRoles().add(role);
            userRepository.save(userApp);
        }
    }

    @Override
    public UserApp getUser(String username) {
        log.info("Fetching user {}", username);
        Optional<UserApp> userOptional = userRepository.findByUsername(username);
        return userOptional.orElse(null);
    }

    @Override
    public List<UserApp> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

}
