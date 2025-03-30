package com.example.task45.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    @OneToOne(mappedBy = "profile")
    private User user;

    public Profile(String address, LocalDate dateOfBirth, Long id, String phoneNumber, User user) {
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Profile() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
