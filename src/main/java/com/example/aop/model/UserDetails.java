package com.example.aop.model;

import org.springframework.stereotype.Component;

@Component
public class UserDetails {
    private String name;
    private String info;
    private Double rating;

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public Double getRating() {
        return rating;
    }
}
