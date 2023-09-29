package com.example.delivery_example.store.repository;

import com.example.delivery_example.store.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
