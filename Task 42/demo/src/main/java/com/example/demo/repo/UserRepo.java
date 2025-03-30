package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    // Find a user by username
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(String username);

    // Get a list of users above a certain age
    @Query("SELECT u FROM User u WHERE u.age > :age")
    List<User> findUsersAboveAge(int age);

    // Update a user's email by username
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.email = :email WHERE u.username = :username")
    int updateUserEmail(String username, String email);

    // Delete a user by username
    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.username = :username")
    int deleteUserByUsername(String username);


    // pagination we add there so far
    // Custom query with pagination
    Page<User> findByAgeGreaterThan(int age, Pageable pageable);
}
