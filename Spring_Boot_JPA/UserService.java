package com.example.springbootmongodbexample.service;

import com.example.springbootmongodbexample.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String id);
    User addUser(User user);
    User updateUser(String id, User user);
    void deleteUser(String id);
    List<User> getUsersByNameStartingWith(String prefix); // New method declaration
}
