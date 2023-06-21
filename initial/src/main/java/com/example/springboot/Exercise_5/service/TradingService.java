package com.example.springboot.Exercise_5.service;

import com.example.springboot.Exercise_5.entity.Trading;
import com.example.springboot.Exercise_5.repository.TradingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradingService {

    @Autowired
    TradingRepository tradingRepository;

    public Trading createTrade(Trading trading){
        return tradingRepository.saveAndFlush(trading);
    }

    public Optional<Trading> getTrade(Long id) {
        return tradingRepository.findById(id);
    }

    public void updateTrade(Trading trading){
        tradingRepository.saveAndFlush(trading);
    }

    public void deleteTrade(Long id){
        tradingRepository.deleteById(id);
    }

    public List<Trading> getTradeList() {
        return tradingRepository.findAll();
    }
}
