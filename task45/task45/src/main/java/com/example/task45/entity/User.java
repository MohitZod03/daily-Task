package com.example.task45.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  String email;
    @OneToOne(cascade = CascadeType.ALL) // Ensures profile is saved with user
    @JoinColumn(name = "profile_id", referencedColumnName = "id") // Foreign Key
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public User(String email, Long id, String name, Profile profile) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.profile = profile;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
