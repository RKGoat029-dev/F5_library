
package com.example.f5_library.service;

import java.util.List;
import java.util.Optional;
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

    // Update
    public User updatedUser(int id, User updatedUser) {

        Optional<User> foundUser = userRepository.findById(id);

        if (foundUser.isPresent()) {
            User resultUser = foundUser.get();

            resultUser.setDni(updatedUser.getDni());
            resultUser.setUserTag(updatedUser.getUserTag());
            resultUser.setFirstName(updatedUser.getFirstName());
            resultUser.setLastName(updatedUser.getLastName());
            resultUser.setUserEmail(updatedUser.getUserEmail());
            resultUser.setUserPhone(updatedUser.getUserPhone());

            return userRepository.save(resultUser);
        }

        throw new RuntimeException("Not found.");
    }

    // Delete
    public void deleteUser(int id) {userRepository.deleteById(id); }


    /* FILTERS */

    // ID
    public Optional<User> findUserById(int id) { return userRepository.findById(id); }
}