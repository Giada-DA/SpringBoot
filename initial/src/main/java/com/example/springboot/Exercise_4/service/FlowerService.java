package com.example.springboot.Exercise_4.service;

import com.example.springboot.Exercise_4.entity.Flower;
import com.example.springboot.Exercise_4.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerService {

    @Autowired
    FlowerRepository flowerRepository;

    public Flower createFlower(Flower flower){
        return flowerRepository.saveAndFlush(flower);
    }

    public Flower getFlower(Long id){
        return flowerRepository.getReferenceById(id);
    }

    public void updateFlower(Flower flower){
        flowerRepository.saveAndFlush(flower);
    }

    public void deleteFlower(Long id){
        flowerRepository.deleteById(id);
    }

    public List<Flower> getFlowerList() {
        return flowerRepository.findAll();
    }
}
