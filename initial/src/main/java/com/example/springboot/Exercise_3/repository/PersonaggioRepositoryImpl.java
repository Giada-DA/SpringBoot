package com.example.springboot.Exercise_3.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;


public class PersonaggioRepositoryImpl implements PersonaggioRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public int deleteOverSimpatia(int simpatia) {
         return entityManager.createQuery("DELETE FROM Personaggio p WHERE p.simpatia > :simpatia")
        .setParameter("simpatia", simpatia)
        .executeUpdate();
    }
}
/*
    @Override
    public User customFindMethod(Long id) {
        return (User) entityManager.createQuery("FROM User u WHERE u.id = :id")
          .setParameter("id", id)
          .getSingleResult();
    }
 */