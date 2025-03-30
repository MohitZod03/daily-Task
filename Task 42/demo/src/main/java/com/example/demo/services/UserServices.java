package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class UserServices {
    private final UserRepo userRepo;

    public UserServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    // add the user
    public String saveUser(User user){
        userRepo.save(user);
        return "User save Successfully";
    }
    // get the all user
    public  List<User> userList(){

        return  userRepo.findAll();
    }
    // get single by id
   public User getById( Long id){
        return userRepo.findById(id).orElseThrow(()-> new RuntimeException("user Not found with id"+id));
    }

    // find the user by user name
    public User findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public List<User> getUsersAboveAge(int age) {
        return userRepo.findUsersAboveAge(age);
    }

    public String updateUserEmail(String username, String email) {
        int updatedRows = userRepo.updateUserEmail(username, email);
        return updatedRows > 0 ? "User email updated successfully!" : "User not found!";
    }

    public String deleteUser(String username) {
        int deletedRows = userRepo.deleteUserByUsername(username);
        return deletedRows > 0 ? "User deleted successfully!" : "User not found!";
    }

}
