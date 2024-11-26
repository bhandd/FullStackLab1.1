package com.example.FullStackLab11.Repositories;

import com.example.FullStackLab11.dao.UserDB;
import com.example.FullStackLab11.model.LoginForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserDB, Long> {
    List<UserDB> findByRole(String role);
    List<UserDB> findByRoleNot(String role);
    UserDB findByNameAndPassword(String name, String password);
}
