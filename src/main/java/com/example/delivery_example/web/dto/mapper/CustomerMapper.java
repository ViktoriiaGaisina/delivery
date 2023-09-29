package com.example.delivery_example.web.dto.mapper;

import com.example.delivery_example.store.entity.CustomerEntity;
import com.example.delivery_example.web.dto.CustomerDTO;

import java.util.List;

public interface CustomerMapper {

    CustomerDTO toDto(CustomerEntity entity);
    List<CustomerDTO> toDto(List<CustomerEntity> entity);
    CustomerEntity toEntity(CustomerDTO dto);
}
