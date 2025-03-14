package com.internship.Task._8.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.internship.Task._8.entity.User;
import com.internship.Task._8.services.UserServices;

@RestController
public class UserController {

   private UserServices userServices;  
    public UserController(UserServices userServices) {
    this.userServices = userServices;
}



    @GetMapping("/getUser")
    public List<User> getUser(){
        return userServices.getAllUsers();
    } 

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user) {
        return userServices.saveUser(user);
    }
    
}
