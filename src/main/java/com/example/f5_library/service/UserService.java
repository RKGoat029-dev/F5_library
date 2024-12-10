
package com.example.f5_library.service;

import java.util.List;
import com.example.f5_library.model.User;
import com.example.f5_library.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    /* CRUD */

    // Create
    public User addUser(User newUser) { return userRepository.save(newUser); }

    // Read
    public List<User> getUsers() { return userRepository.findAll(); }
}
