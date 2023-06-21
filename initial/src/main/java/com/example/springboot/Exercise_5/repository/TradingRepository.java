package com.example.springboot.Exercise_5.repository;

import com.example.springboot.Exercise_5.entity.Trading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradingRepository extends JpaRepository<Trading, Long> {
}
