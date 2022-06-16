package com.example.aop.controller;

import com.example.aop.model.User;
import com.example.aop.model.UserBuilder;
import com.example.aop.model.UserDetails;
import com.example.aop.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aop")
public class UserController {

    private final UserService userService;
    private UserBuilder builder;

    public UserController(UserService userService, UserBuilder builder) {
        this.userService = userService;
        this.builder = builder;
    }

    @PostMapping
    public User addUser(@RequestBody UserDetails userDetails){
        User user = builder
                .newUser()
                .setName(userDetails.getName())
                .setInfo(userDetails.getInfo())
                .setRating(userDetails.getRating())
                .build();
        return userService.add(user);
    }
}
