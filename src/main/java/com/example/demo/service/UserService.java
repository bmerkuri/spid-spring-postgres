package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //search user by Id
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    //create user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //update user by inserting their id
    public User updateUser(User user, long id) throws Exception {
        if (!getUserById(id).isPresent()) {
            throw new Exception("You are trying to update an user that does not exist");
        }
        user.setId(id);
        return userRepository.save(user);
    }

}