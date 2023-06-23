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
/*
@Id
@SequenceGenerator(name = "pet_seq", sequenceName = "pet_sequence", initialValue = 1, allocationSize = 20)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
@Column(name = "id", nullable = false)
private Long id;
 */