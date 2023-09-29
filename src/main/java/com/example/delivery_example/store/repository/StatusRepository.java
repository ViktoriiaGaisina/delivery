package com.example.delivery_example.store.repository;

import com.example.delivery_example.store.entity.StatusOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<StatusOrderEntity, Long> {

    Optional<StatusOrderEntity> findByName(String name);
}
