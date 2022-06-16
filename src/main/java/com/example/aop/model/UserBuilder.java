package com.example.aop.model;

import org.springframework.stereotype.Component;

@Component
public class UserBuilder {

    private User user = new User();

    public UserBuilder setName(String name) {
        user.setName(name);
        return this;
    }

    public UserBuilder setInfo(String info) {
        user.setInfo(info);
        return this;
    }

    public UserBuilder setRating(Double rating) {
        user.setRating(rating);
        return this;
    }

    public User build() {
        return user;
    }
}
