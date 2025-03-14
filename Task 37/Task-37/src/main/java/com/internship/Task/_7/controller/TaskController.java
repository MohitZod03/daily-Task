package com.internship.Task._7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TaskController {
    @GetMapping("/masage")
    public String getMassage() {
        return "Wellcome to spring boot appication.";
    }
    
}
