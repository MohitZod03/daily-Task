package com.internship.Task._9.employ.management.system.servicesImp;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.internship.Task._9.employ.management.exceptionHandling.CustomException.UserNotFoundException;
import com.internship.Task._9.employ.management.system.entity.User;
import com.internship.Task._9.employ.management.system.repository.UserRepo;
import com.internship.Task._9.employ.management.system.services.UserServices;

import ch.qos.logback.classic.Logger;

@Service
public class UserServicesImp implements UserServices {

     private static final Logger logger = (Logger) LoggerFactory.getLogger(UserServicesImp.class);

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
    public Optional<User> getUserById(Long id) {
       
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            return user;
 
        }else{
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
       
       
       
    }
    @Override
    public User getUserByEmail(String email) {
       
        User user = userRepo.findByEmail(email);
        return user;
       
    }
    
    @Override
    public User updateUser(Long id, User user) {
       
       User user2 = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setRole(user.getRole());
       
        return  userRepo.save(user2);
    }


    @Override
    public String deleteUser(Long id) {
       
        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
        userRepo.delete(user);
        return "User deleted successfully";
       
    }



}
