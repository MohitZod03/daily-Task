package com.internship.Task._9.employ.management.system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.internship.Task._9.employ.management.system.entity.User;

@Service
public interface UserServices {

    public String saveUser(User user);
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User getUserByEmail(String email);
    public User updateUser(Long id,User user);
    public String deleteUser(Long id);
    
    
    

    
} 

