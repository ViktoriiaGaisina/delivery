package com.example.delivery_example.web.dto.mapper;

import com.example.delivery_example.store.entity.OrderEntity;
import com.example.delivery_example.web.dto.OrderDTO;

import java.util.List;

public interface OrderMapper {
    OrderDTO toDto(OrderEntity entity);
    List<OrderDTO> toDto(List<OrderEntity> entity);
    OrderEntity toEntity(OrderDTO dto);
}
