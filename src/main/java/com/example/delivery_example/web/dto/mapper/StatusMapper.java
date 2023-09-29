package com.example.delivery_example.web.dto.mapper;

import com.example.delivery_example.store.entity.StatusOrderEntity;
import com.example.delivery_example.web.dto.StatusOrderDTO;

public interface StatusMapper {

    StatusOrderDTO toDto(StatusOrderEntity entity);

    StatusOrderEntity toEntity(StatusOrderDTO dto);
}
