package com.example.springbootmongodbexample.repository;

import com.example.springbootmongodbexample.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByNameStartingWith(String prefix); // Custom query method
}
