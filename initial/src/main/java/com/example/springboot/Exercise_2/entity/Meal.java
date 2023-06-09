package com.example.springboot.Exercise_2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Meal {

    private String tipo;
    private String perlaDiSaggezza;
    private int prezzo;
}
