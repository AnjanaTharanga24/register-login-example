package com.example.backend.service;

import com.example.backend.controller.request.LoginRequest;
import com.example.backend.exception.NotFoundException;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    public User register(User user){
        User newUser = new User();

        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        return userRepository.save(newUser);
    }

    public User login(LoginRequest loginRequest) throws NotFoundException {
        Optional<User> user = userRepository.findByEmailAndAndPassword(loginRequest.getEmail(), loginRequest.getPassword());

        if (!user.isPresent()){
            throw new NotFoundException("invalid credential");
        }

        User loggedUser = user.get();

        return loggedUser;
    }

}
