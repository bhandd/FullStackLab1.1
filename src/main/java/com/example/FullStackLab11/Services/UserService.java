package com.example.FullStackLab11.Services;

import com.example.FullStackLab11.Repositories.UserRepository;
import com.example.FullStackLab11.dao.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**just a comment*/
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create
    public UserDB saveUser(UserDB user) {
        return userRepository.save(user);
    }

    // Read
    public List<UserDB> getAllUsers() {
        return (List<UserDB>) userRepository.findAll();
    }

    public List<UserDB> getAllPatients() {
        return userRepository.findByRole("patient");
    }

    public List<UserDB> getAllStaff() {
        return userRepository.findByRoleNot("patient");
    }

    public Optional<UserDB> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public boolean existsById(Long id) {
        Optional<UserDB> u = userRepository.findById(id);
        return u.isPresent();
    }

    // Update
    public UserDB updateUser(Long id, UserDB updatedUser) {
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