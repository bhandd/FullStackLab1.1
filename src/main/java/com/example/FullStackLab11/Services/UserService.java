package com.example.FullStackLab11.Services;

import com.example.FullStackLab11.Repositories.UserRepository;
import com.example.FullStackLab11.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Read
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public List<User> getAllPatients() {
        return userRepository.findByRole("patient");
    }

    public List<User> getAllStaff() {
        return userRepository.findByRoleNot("patient");
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public boolean existsById(Long id) {
        Optional<User> u = userRepository.findById(id);
        return u.isPresent();
    }

    // Update
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
    }

    // Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}