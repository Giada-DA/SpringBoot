package com.example.springboot.Exercise_3.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersonaggioRepositoryImpl implements PersonaggioRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deleteOverSimpatia(int simpatia) {
         entityManager.createQuery("DELETE FROM Personaggio p WHERE p.simpatia >: simpatia")
        .setParameter("simpatia", simpatia)
        .getSingleResult();
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