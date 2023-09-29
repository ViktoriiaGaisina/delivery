package com.example.delivery_example.store.repository;

import com.example.delivery_example.store.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DishRepository extends JpaRepository<DishEntity, Long> {

    Optional<DishEntity> findDishEntitiesByName(String name);
}
