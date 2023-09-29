package com.example.delivery_example.web.dto.mapper;

import com.example.delivery_example.store.entity.StatusOrderEntity;
import com.example.delivery_example.web.dto.StatusOrderDTO;
import org.springframework.stereotype.Component;

@Component
public class StatusMapperImpl implements StatusMapper {

    @Override
    public StatusOrderDTO toDto(StatusOrderEntity entity) {
        return StatusOrderDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public StatusOrderEntity toEntity(StatusOrderDTO dto) {
        return StatusOrderEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
