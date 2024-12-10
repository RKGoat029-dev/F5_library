package com.example.f5_library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.f5_library.model.User;
import com.example.f5_library.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    /* CRUD */

    // Create
    @PostMapping("/users")
    public void createUser(@RequestBody User newUser) { userService.addUser(newUser); }

    // Read
    @GetMapping("/users")
    public List<User> getAllUsers() { return userService.getUsers(); }
}
