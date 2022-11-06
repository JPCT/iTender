package com.itender.api.rest;

import java.io.IOException;
import java.util.List;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itender.api.request.RoleToUserRequest;
import com.itender.model.Role;
import com.itender.model.UserApp;
import com.itender.security.SecurityConfig;
import com.itender.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", maxAge = 86400)
@RestController
@Tag(name = "UserApp controller", description = "All users actions")
public class UserController {

    private final UserService userService;
    private final SecurityConfig securityConfig;

    @Autowired
    public UserController(UserService userService, SecurityConfig securityConfig) {
        this.userService = userService;
        this.securityConfig = securityConfig;
    }

    @Operation(summary = "Retrieve all users")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Users retrieved."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @GetMapping("/user/all")
    public ResponseEntity<List<UserApp>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @Operation(summary = "Create a userApp")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "UserApp created."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @PostMapping("/user/save")
    public ResponseEntity<UserApp> saveUser(@RequestBody UserApp userApp) {
        return new ResponseEntity<>(userService.saveUser(userApp), HttpStatus.CREATED);
    }

    @Operation(summary = "Create a role")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Role created."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return new ResponseEntity<>(userService.saveRole(role), HttpStatus.CREATED);
    }

    @Operation(summary = "Add role to user")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Role added to user."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @PostMapping("/role/addToUser")
    public ResponseEntity<Void> addRoleToUser(@RequestBody RoleToUserRequest request) {
        userService.addRoleToUser(request.getUsername(), request.getRoleName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Refresh access token")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Token refreshed."),
                    @ApiResponse(responseCode = "400", description = "Error in input data.", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal error.", content = @Content
                    )
            }
    )
    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response)
            throws IOException, LoginException {

        securityConfig.refreshToken(request, response);
    }

}
