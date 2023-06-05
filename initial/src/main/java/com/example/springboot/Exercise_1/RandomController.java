package com.example.springboot.Exercise_1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {

    @GetMapping("/random")
    public ResponseEntity<String> getRandomResult() {
        boolean isSuccess = new java.util.Random().nextBoolean();

        if (isSuccess) {
            String successMessage = "Richiesta eseguita con successo.";
            return ResponseEntity.status(HttpStatus.OK).body(successMessage);
        } else {
            String errorMessage = "Richiesta fallita";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

}
