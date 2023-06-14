package com.example.springboot.Exercise_1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @GetMapping("/info")
    public ResponseEntity<String> getInfo() {
        String message = "99 scimmie saltavano sul letto...il resto è un contenuto per adulti";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
