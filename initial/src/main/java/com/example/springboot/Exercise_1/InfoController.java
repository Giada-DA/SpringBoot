package com.example.springboot.Exercise_1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @GetMapping("/info")
    public ResponseEntity<String> getInfo() {
        String message = "200 scimmie saltavano sul letto...o forse no";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
