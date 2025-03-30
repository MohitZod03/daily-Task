package com.internship.Task._9.employ.management.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internship.Task._9.employ.management.system.entity.User;
import com.internship.Task._9.employ.management.system.servicesImp.UserServicesImp;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServicesImp userServicesImp;

    public UserController(UserServicesImp userServicesImp) {
        this.userServicesImp = userServicesImp;
    }
    
   @PostMapping("/saveUser")
   public String saveUser(@RequestBody User user) {
        userServicesImp.saveUser(user);
        return "User saved successfully";
   }
   
   @GetMapping("/getAllUsers")
   
   public List<User> getAllUsers() {
        return userServicesImp.getAllUsers();
   }
   
   
   @GetMapping("/getUserById/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable  Long id) {
            Optional<User> user = userServicesImp.getUserById(id);
       return new ResponseEntity<>(user, HttpStatus.FOUND);

    }
   
    @GetMapping("/getUserByEmail/{email}")
    public User getUserByEmail(@PathVariable String email) {
          return userServicesImp.getUserByEmail(email);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
          return userServicesImp.updateUser(id, user);
    }
   
    @DeleteMapping("/deleteUser/{id}")  
    public String deleteUser(@PathVariable Long id) {
          return userServicesImp.deleteUser(id);
    }
}
