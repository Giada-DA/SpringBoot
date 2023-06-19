package com.example.springboot.Exercise_3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Personaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String nome;
    private int simpatia;
}