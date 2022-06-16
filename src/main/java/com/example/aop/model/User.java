package com.example.aop.model;


import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    private String name;
    private String info;
    private Double rating;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public Double getRating() {
        return rating;
    }

    public Long getId() {
        return id;
    }
}
