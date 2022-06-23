package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository usersRepository;

    //get a specific user by their id
    public Optional<User> getUserById(long id) {
        return usersRepository.findById(id);
    }

    // Update a user using id as a reference
    public User updateUserById(long id, String name, String surname, String email) throws Exception {
        Optional<User> user = usersRepository.findById(id);

        if (!user.isPresent()) {
            throw new Exception("This user does not exists");
        }

        if (name != null) {
            user.get().setName(name);
        }
        if (surname != null) {
            user.get().setSurname(surname);
        }
        if (email != null) {
            user.get().setEmail(email);
        }

        return usersRepository.save(user.get());
    }

    //create a user
    public User createUser(User user) {
        return usersRepository.save(user);
    }

}