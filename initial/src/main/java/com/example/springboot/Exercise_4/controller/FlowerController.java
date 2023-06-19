package com.example.springboot.Exercise_4.controller;

import com.example.springboot.Exercise_4.entity.Flower;
import com.example.springboot.Exercise_4.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FlowerController {

    @Autowired
    FlowerService flowerService;

    @PostMapping("/addFlower")
    public Flower addFlower(@RequestBody Flower flower) {
        return flowerService.createFlower(flower);
    }

    //AHAHAH
    @GetMapping("/get/{id}")
    public Optional<Flower> getOneFlower(@PathVariable long id) {
        return flowerService.getFlower(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Flower flower) {
        flower.setId(id);
        flowerService.updateFlower(flower);
        return new ResponseEntity<>("I dati del fiore sono stati aggiornati", HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlowerById(@PathVariable Long id) {
        flowerService.deleteFlower(id);
        return new ResponseEntity<>("Il fiore è stato rimosso", HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public List<Flower> findAll() {
        return flowerService.getFlowerList();
    }
}
