package com.example.springboot.Exercise_5.controller;

import com.example.springboot.Exercise_5.entity.Trading;
import com.example.springboot.Exercise_5.service.TradingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TradingController {

    @Autowired
    TradingService tradingService;

    @PostMapping("/addTrade")
    public Trading addTrade(@RequestBody Trading trading) {
        return tradingService.createTrade(trading);
    }

    @GetMapping("/getTrade/{id}")
    public Optional<Trading> getOneTrade(@PathVariable long id) {
        return tradingService.getTrade(id);
    }

    @PutMapping("/updateTrade/{id}")
    public ResponseEntity<String> updateTrade(@PathVariable Long id, @RequestBody Trading trading) {
        trading.setId(id);
        tradingService.updateTrade(trading);
        return new ResponseEntity<>("I dati dell'operazione sono stati aggiornati", HttpStatus.OK);
    }

    @DeleteMapping("/deleteTrade/{id}")
    public ResponseEntity<String> deleteTradeById(@PathVariable Long id) {
        tradingService.deleteTrade(id);
        return new ResponseEntity<>("Il trade è stato annullato", HttpStatus.OK);
    }

    @GetMapping("C")
    public List<Trading> findAll() {
        return tradingService.getTradeList();
    }
}
