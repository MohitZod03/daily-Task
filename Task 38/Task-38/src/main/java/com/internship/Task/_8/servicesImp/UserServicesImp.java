package com.internship.Task._8.servicesImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.internship.Task._8.entity.User;
import com.internship.Task._8.repository.UserRepo;
import com.internship.Task._8.services.UserServices;

@Service
public class UserServicesImp implements UserServices {

    private UserRepo userRepo;
    public UserServicesImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String saveUser(User user) {
       
        userRepo.save(user);
        return "User saved successfully";
       
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        for (User u : users) {
            System.out.println("User: " + u.getName() + ", Email: " + u.getEmail() + ", Password: " + u.getPassword());
        }
        return users;
    }
        
}
