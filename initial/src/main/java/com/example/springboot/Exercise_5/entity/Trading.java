package com.example.springboot.Exercise_5.entity;

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
public class Trading {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String operationName;
    public int lot;
    public boolean isBuy;
}
