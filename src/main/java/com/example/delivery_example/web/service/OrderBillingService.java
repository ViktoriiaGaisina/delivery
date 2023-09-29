package com.example.delivery_example.web.service;

import com.example.delivery_example.store.entity.DishEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderBillingService {
    public BigDecimal calculateTotalAmount(List<DishEntity> dishEntities) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (DishEntity dish : dishEntities) {
            totalAmount = totalAmount.add(dish.getPrice());
        }
        return totalAmount;
    }
}
