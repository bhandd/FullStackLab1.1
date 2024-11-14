package com.example.FullStackLab11.Repositories;

import com.example.FullStackLab11.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByRole(String role);
    List<User> findByRoleNot(String role);
}
