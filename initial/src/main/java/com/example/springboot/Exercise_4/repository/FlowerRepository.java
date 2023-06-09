package com.example.springboot.Exercise_4.repository;

import com.example.springboot.Exercise_4.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Long> {
}
