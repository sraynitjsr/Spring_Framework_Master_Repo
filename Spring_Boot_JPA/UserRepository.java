package com.example.springbootmongodbexample.repository;

import com.example.springbootmongodbexample.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByNameStartingWith(String prefix); // Custom query method

    @Query("{'email' : {$regex : ?0}}")
    List<User> findByEmailRegex(String domain); // Custom query method using @Query annotation
}
