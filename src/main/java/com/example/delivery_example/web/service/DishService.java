package com.example.delivery_example.web.service;

import com.example.delivery_example.store.entity.DishEntity;
import com.example.delivery_example.web.dto.DishDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DishService {
    DishEntity getDishEntityById(long id);

    DishDTO getDishByName(String name);

    Page<DishDTO> getDishByPage(int pageNo, int pageSize);
}

