package com.internship.Task._9.employ.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internship.Task._9.employ.management.system.entity.User;

public interface UserRepo  extends JpaRepository<User, Long> {

    User findByEmail(String email);

    
} 

