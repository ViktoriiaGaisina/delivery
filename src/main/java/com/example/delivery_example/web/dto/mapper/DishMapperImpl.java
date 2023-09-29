package com.example.delivery_example.web.dto.mapper;

import com.example.delivery_example.store.entity.DishEntity;
import com.example.delivery_example.web.dto.DishDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DishMapperImpl implements DishMapper {

    @Override
    public DishDTO toDto(DishEntity entity) {
        return DishDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }

    @Override
    public List<DishDTO> toDto(List<DishEntity> entity) {
        return entity.stream()
                .map(dishEntity -> toDto(dishEntity))
                .collect(Collectors.toList());
    }

    @Override
    public DishEntity toEntity(DishDTO dto) {
        return DishEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
    }
}
