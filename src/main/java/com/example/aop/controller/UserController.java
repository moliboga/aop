package com.example.aop.controller;

import com.example.aop.model.User;
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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody UserDetails userDetails){
        User user = User.builder()
                .setName(userDetails.getName())
                .setInfo(userDetails.getInfo())
                .setRating(userDetails.getRating())
                .build();
        return userService.add(user);
    }
}
