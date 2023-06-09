package com.example.springboot.Exercise_1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Bienvenido!";
    }

    @GetMapping("/greeting")
    public ResponseEntity<String> getGreetingMessage() {
        String message = "Riuscirà? Riesce!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}


