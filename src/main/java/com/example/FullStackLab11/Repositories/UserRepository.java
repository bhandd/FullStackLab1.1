package com.example.FullStackLab11.Repositories;

import com.example.FullStackLab11.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
