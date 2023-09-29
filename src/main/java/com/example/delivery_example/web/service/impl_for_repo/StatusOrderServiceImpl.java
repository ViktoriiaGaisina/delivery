package com.example.delivery_example.web.service.impl_for_repo;

import com.example.delivery_example.store.entity.OrderEntity;
import com.example.delivery_example.store.entity.StatusOrderEntity;
import com.example.delivery_example.store.repository.OrderRepository;
import com.example.delivery_example.store.repository.StatusRepository;
import com.example.delivery_example.web.dto.StatusOrderDTO;
import com.example.delivery_example.web.dto.mapper.StatusMapper;
import com.example.delivery_example.web.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StatusOrderServiceImpl implements StatusService {
    private final StatusRepository statusRepository;
    private final OrderRepository orderRepository;
    private final StatusMapper statusMapper;

    @Autowired
    public StatusOrderServiceImpl(StatusRepository statusRepository, OrderRepository orderRepository,
                                  StatusMapper statusMapper) {
        this.statusRepository = statusRepository;
        this.orderRepository = orderRepository;
        this.statusMapper = statusMapper;
    }

    @Override
    public StatusOrderEntity getStatusByName(String name) {
        return null;
    }

    @Override
    public StatusOrderDTO getStatusByOrderId(long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("order not found"));
        StatusOrderEntity statusOrderEntity = orderEntity.getStatusOrderEntity();
        return statusMapper.toDto(statusOrderEntity);
    }
}
