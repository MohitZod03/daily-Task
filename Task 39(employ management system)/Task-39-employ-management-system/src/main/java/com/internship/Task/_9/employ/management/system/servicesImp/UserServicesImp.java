package com.internship.Task._9.employ.management.system.servicesImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.internship.Task._9.employ.management.system.entity.User;
import com.internship.Task._9.employ.management.system.repository.UserRepo;
import com.internship.Task._9.employ.management.system.services.UserServices;

@Service
public class UserServicesImp implements UserServices {

    private final UserRepo userRepo;
    public UserServicesImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String saveUser(User user) {

       userRepo.save(user);
        return "User saved suceesfully";
       
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        for (User u : users) {
            System.out.println("User: " + u.getName() + ", Email: " + u.getEmail() + ", Password: " + u.getPassword());
        }
        return users;
    }
    @Override
    public User getUserById(Long id) {
       
        User user = userRepo.findById(id).get();
        return user;
       
    }

    @Override
    public User getUserByEmail(String email) {
       
        User user = userRepo.findByEmail(email);
        return user;
       
    }
    
    @Override
    public User updateUser(Long id, User user) {
       
       User user2 = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setRole(user.getRole());
       
        return  userRepo.save(user2);
    }


    @Override
    public String deleteUser(Long id) {
       
        User user = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepo.delete(user);
        return "User deleted successfully";
       
    }


}
