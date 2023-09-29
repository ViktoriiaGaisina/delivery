package com.example.delivery_example.web.dto.mapper;

import com.example.delivery_example.store.entity.DishEntity;
import com.example.delivery_example.web.dto.DishDTO;

import java.util.List;

public interface DishMapper {
    DishDTO toDto(DishEntity entity);
    List<DishDTO> toDto(List<DishEntity> entity);
    DishEntity toEntity(DishDTO dto);
}
