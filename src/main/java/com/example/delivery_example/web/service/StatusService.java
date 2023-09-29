package com.example.delivery_example.web.service;


import com.example.delivery_example.store.entity.StatusOrderEntity;
import com.example.delivery_example.web.dto.StatusOrderDTO;

public interface StatusService {

    StatusOrderEntity getStatusByName(String name);

    StatusOrderDTO getStatusByOrderId(long orderId);
}
