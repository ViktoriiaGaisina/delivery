package com.example.delivery_example.web.dto.mapper;

import com.example.delivery_example.store.entity.DishEntity;
import com.example.delivery_example.store.entity.OrderEntity;
import com.example.delivery_example.web.dto.DishDTO;
import com.example.delivery_example.web.dto.OrderDTO;
import com.example.delivery_example.web.dto.mapper.DishMapper;
import com.example.delivery_example.web.service.OrderBillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapperImpl implements OrderMapper {
    private final DishMapper dishMapper;
    private final OrderBillingService orderBillingService;

    @Autowired
    public OrderMapperImpl(DishMapper dishMapper, OrderBillingService orderBillingService) {
        this.dishMapper = dishMapper;
        this.orderBillingService = orderBillingService;
    }

    @Override
    public OrderDTO toDto(OrderEntity entity) {
        List<DishEntity> dishEntities = entity.getDishEntities();
        List<DishDTO> dishDTOS = dishMapper.toDto(dishEntities);
        return OrderDTO.builder()
                .id(entity.getId())
                .numberOfOrder(entity.getNumberOfOrder())
                .created(entity.getCreated())
                .dishDTOS(dishDTOS)
                .statusName(entity.getStatusOrderEntity().getName())
                .toPay(orderBillingService.calculateTotalAmount(dishEntities))
                .build();
    }

    @Override
    public List<OrderDTO> toDto(List<OrderEntity> entity) {
        return null;
    }

    @Override
    public OrderEntity toEntity(OrderDTO dto) {
        return null;
    }
}
