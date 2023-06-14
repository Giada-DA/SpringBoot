package com.example.springboot.Exercise_2.controllers;

import com.example.springboot.Exercise_2.entity.Meal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MealController {

    List<Meal> mealList = new ArrayList<>(Arrays.asList(
            new Meal("Pasta fresca", "Scusi, quanto ha detto che costa?", 12),
            new Meal("Piadina", "Mi raccomando che sia spessa", 5),
            new Meal("Pizza", "Sarà anche al carbone nero ma per me è bruciata...",10),
            new Meal("Lasagne", "Mi piace la lasagna! E poi mi piaci tu", 8)
    ));

    @GetMapping("/meals")
    public List<Meal> getListMeal(){
        return mealList;
    }

    @GetMapping("/meal/{name}")
    public ResponseEntity<?> getOneMeal(@PathVariable String name){
        for(Meal meal: mealList){
            if (meal.getTipo().equalsIgnoreCase(name)){
                return new ResponseEntity<>(meal, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Non esiste nessun piatto con quel nome", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/meal/description-match/{word}")
    public ResponseEntity<?> getMatchDescription(@PathVariable String word){
        for (Meal meal: mealList){
            if (meal.getPerlaDiSaggezza().contains(word)){
                return new ResponseEntity<>(meal, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("La ricerca non è andata a buon fine...ritenta sarai più fortunato", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/meal/price")
    public List<Meal> getMealByPrice(@RequestParam("min") int priceMin, @RequestParam("max") int priceMax){
        List<Meal> mealPrice = new ArrayList<>();
        for(Meal meal: mealList){
            if (meal.getPrezzo() > priceMin && meal.getPrezzo() < priceMax){
                mealPrice.add(meal);
            }
        }
        return mealPrice;
    }
}
