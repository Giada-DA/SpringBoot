package com.example.springboot.Exercise_3.controllers;

import com.example.springboot.Exercise_3.entity.Personaggio;
import com.example.springboot.Exercise_3.repository.PersonaggioRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaggioController {

    public static int statusConflict = 409;

    @Autowired
    PersonaggioRepository personaggioRepository;

    @PostMapping("/personaggio")
    public Personaggio create(@RequestBody Personaggio car){
        return personaggioRepository.saveAndFlush(car);
    }

    @PutMapping("/personaggio/{id}")
    public ResponseEntity<?> updateName(@PathVariable("id") Long id, @RequestBody Personaggio personaggioNuovo){
        if (personaggioRepository.existsById(id)){
            Personaggio personaggio = personaggioRepository.getById(id);
            personaggio.setNome(personaggioNuovo.getNome());
            personaggio = personaggioRepository.saveAndFlush(personaggio);
            return new ResponseEntity<>(personaggio, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Non è presente questo personaggio... :(", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteOnePersonaggio/{id}")
    public void delete(@PathVariable Long id, HttpServletResponse response){
        if (personaggioRepository.existsById(id)){
            personaggioRepository.deleteById(id);
        }else{
            response.setStatus(statusConflict);
        }
    }

    @DeleteMapping("/personaggio/{simpatia}")
    public ResponseEntity<String> deleteOverThatPrice(@PathVariable int simpatia){
        int personaggiEliminati = personaggioRepository.deleteOverSimpatia(simpatia);
        return new ResponseEntity<>("Sono state eliminati " + personaggiEliminati + " personaggi", HttpStatus.OK);

    }

    @PutMapping("/personaggio/{id}/simpatia")
    public ResponseEntity<?> updateSimpy(@PathVariable("id") Long id, @RequestBody Personaggio personaggioNuovo){
        if (personaggioRepository.existsById(id)){
            Personaggio personaggio = personaggioRepository.getById(id);
            personaggio.setSimpatia(personaggioNuovo.getSimpatia());
            personaggio = personaggioRepository.saveAndFlush(personaggio);
            return new ResponseEntity<>(personaggio, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Mi spiace, quel che è fatto è fatto", HttpStatus.BAD_REQUEST);
        }
    }
}
