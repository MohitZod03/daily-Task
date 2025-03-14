package com.internship.Task._6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    
}
