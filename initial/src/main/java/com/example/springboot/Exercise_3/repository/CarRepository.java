package com.example.springboot.Exercise_3.repository;

import com.example.springboot.Exercise_3.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
