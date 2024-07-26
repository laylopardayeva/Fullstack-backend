package com.fullstack_backend.fullstack_backend.Module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity                                           // annotation of JPA class
public class User {


    @Id                                           // primary key of entity table
    @GeneratedValue
    // generate id automatically

    // attributes represent in database table
    private Long id;
    private String username;
    private String name;

    public String getEmail() {
        return email;
    }


    // getter and setter methods
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String email;
}