package com.example.springbootmongodbexample.service;

import com.example.springbootmongodbexample.model.User;
import com.example.springbootmongodbexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersByNameStartingWith(String prefix) {
        return userRepository.findByNameStartingWith(prefix);
    }

    @Override
    public List<User> getUsersByEmailDomain(String domain) {
        return userRepository.findByEmailRegex(".*@" + domain);
    }
}
