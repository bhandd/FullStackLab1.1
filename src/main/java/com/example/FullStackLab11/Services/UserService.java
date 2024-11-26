package com.example.FullStackLab11.Services;

import com.example.FullStackLab11.Repositories.UserRepository;
import com.example.FullStackLab11.dao.UserDB;
import com.example.FullStackLab11.model.LoginForm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**just a comment*/
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // POST
    public void saveUser(UserDB user) {
        userRepository.save(user);
    }

    // READ
    public List<UserDB> getAllUsers() {
        return (List<UserDB>) userRepository.findAll();
    }

    // READ
    public List<UserDB> getAllPatients() {
        return userRepository.findByRole("patient");
    }

    // READ
    public List<UserDB> getAllStaff() {
        return userRepository.findByRoleNot("patient");
    }

    // READ
    public UserDB getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserDB validateNewUser(LoginForm credentials) {
        return userRepository.findByNameAndPassword(credentials.getUsername(), credentials.getPassword());
    }

    @Transactional
    public UserDB registerNewUser(UserDB userDB) {
        if (userDB == null) {
            throw new IllegalArgumentException("Invalid user data");
        }
        if (userDB.getName() == null) {
            throw new IllegalArgumentException("Invalid username data");
        }
        if (userDB.getPassword() == null) {
            throw new IllegalArgumentException("Invalid userpassword data");
        }
        return userRepository.save(userDB);
    }

    public boolean existsById(Long id) {
        Optional<UserDB> u = userRepository.findById(id);
        return u.isPresent();
    }

    // PUT
    public UserDB updateUser(Long id, UserDB updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}