package com.example.springboot.Exercise_3.controllers;

import com.example.springboot.Exercise_3.entity.Car;
import com.example.springboot.Exercise_3.repository.CarRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    @Autowired
    CarRepository carRepository;

    @PostMapping("/car")
    public Car create(@RequestBody Car car){
        return carRepository.saveAndFlush(car);
    }

    @PutMapping("/car/{model}")
    public ResponseEntity<?> update(@PathVariable("model") String model, @RequestParam int modelCar){
        Car car;
        if (carRepository.existsById(model)){
            car = carRepository.getById(model);
            car.setPrice(modelCar);
            car = carRepository.saveAndFlush(car);
        }else{
            return new ResponseEntity<>("Non è presente il modello di quest'auto", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(carRepository, HttpStatus.OK);
    }

    /*@PutMapping("/car/{model}")
    public Car updateModel(@PathVariable String model, @RequestBody String modelCar){
        Car car;
        if (carRepository.existsById(model)){
            car = carRepository.getById(model);
            car.setModel(modelCar);
            car = carRepository.saveAndFlush(car);
        }
        return car;
    }

     */

    @DeleteMapping("/car/{model}")
    public void deleteOneCar(@PathVariable String model, HttpServletResponse response){
        if (carRepository.existsById(model)){
            carRepository.deleteById(model);
        }else{
            response.setStatus(409);
        }
    }
/*
    @DeleteMapping("/car/price/{price}")
    public void deleteOverThatPrice(@PathVariable int price){
        if (carRepository.)
    }

 */

    @PutMapping("/car/{model}/price")
    public Car updatePrice(@PathVariable String model, @RequestParam int price){
        Car car;
        if (carRepository.existsById(model)){
            car = carRepository.getById(model);
            car.setPrice(price);
            car = carRepository.saveAndFlush(car);
        }else{
            car = new Car();
        }
        return car;
    }

}
