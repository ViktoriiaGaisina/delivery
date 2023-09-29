package com.example.delivery_example.store.repository;


import com.example.delivery_example.store.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByUsername(String username);
}
