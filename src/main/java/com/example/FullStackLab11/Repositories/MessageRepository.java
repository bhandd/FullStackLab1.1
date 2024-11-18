package com.example.FullStackLab11.Repositories;

import com.example.FullStackLab11.dao.MessageDB;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<MessageDB, Long> {
    List<MessageDB> findAllBySenderId(Long senderId);

    List<MessageDB> findAllByRecieverId(Long receiverId);
}
