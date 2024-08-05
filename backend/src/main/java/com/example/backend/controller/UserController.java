package com.example.backend.controller;

import com.example.backend.controller.request.LoginRequest;
import com.example.backend.exception.NotFoundException;
import com.example.backend.model.User;
import com.example.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;
    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return  userService.register(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody LoginRequest loginRequest) throws NotFoundException {
        return userService.login(loginRequest);
    }
}
