package com.example.aop.service;

import com.example.aop.model.User;
import com.example.aop.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User add(User user){
        return repo.save(user);
    }
}
