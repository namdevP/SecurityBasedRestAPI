package com.example.securitybasedrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/development")
public class MyController {

    @PostMapping("/home")
    public String home(){
        return "Welcome Home";
    }

    @GetMapping("/home")
    public String house(){
        return "Welcome Home";
    }
}
