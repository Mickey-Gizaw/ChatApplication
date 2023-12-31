package com.doodle.backend.repository;

import com.doodle.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
    List<User> findAll();
}
