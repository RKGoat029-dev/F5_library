
package com.example.f5_library.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    // Update
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        try {
            User updatingUser = userService.updatedUser(id,  updatedUser);
            return new ResponseEntity<>(updatingUser, HttpStatus.OK);
        }
        catch (Exception e) { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }

    // Delete
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) { userService.deleteUser(id); }


    /* FILTERS */

    // ID
    @GetMapping("/users/id/{id}")
    public ResponseEntity<User> findUserWithId(@PathVariable int id) {

        Optional<User> foundUserWithId = userService.findUserById(id);

        if(foundUserWithId.isPresent()) { return new ResponseEntity<>(foundUserWithId.get(), HttpStatus.FOUND); }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
