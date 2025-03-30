package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    // Add a new user
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        String response = userServices.saveUser(user);
        return ResponseEntity.ok(response);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServices.userList();
        return ResponseEntity.ok(users);
    }

    // Get a single user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userServices.getById(id);
        return ResponseEntity.ok(user);
    }

    // Find a user by username
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userServices.findUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    // Get a list of users above a certain age
    @GetMapping("/above-age/{age}")
    public ResponseEntity<List<User>> getUsersAboveAge(@PathVariable int age) {
        List<User> users = userServices.getUsersAboveAge(age);
        return ResponseEntity.ok(users);
    }

    // Update a user's email
    @PutMapping("/{username}/update-email")
    public ResponseEntity<String> updateUserEmail(@PathVariable String username, @RequestBody Map<String, String> request) {
        String email = request.get("email"); // Extract email from JSON request body
        String response = userServices.updateUserEmail(username, email);
        return ResponseEntity.ok(response);
    }

    // Delete a user by username
    @DeleteMapping("/deleteByUserName/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        String response = userServices.deleteUser(username);
        return ResponseEntity.ok(response);
    }

    // pagination in controller
    // Get users with pagination
    @GetMapping("/pagination")
    public ResponseEntity<Page<User>> getUsersWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(userServices.getUsersWithPagination(page, size));
    }

    // Get users with pagination and sorting
    @GetMapping("/pagination-sorting") // Full path will be "/users/pagination-sorting"
    public ResponseEntity<Page<User>> getUsersWithSorting(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(userServices.getUsersWithSorting(page, size, sortBy));
    }
}
