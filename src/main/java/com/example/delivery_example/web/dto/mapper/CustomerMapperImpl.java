package com.example.delivery_example.web.dto.mapper;

import com.example.delivery_example.store.entity.CustomerEntity;
import com.example.delivery_example.web.dto.CustomerDTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO toDto(CustomerEntity entity) {
        return CustomerDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .build();
    }

    @Override
    public List<CustomerDTO> toDto(List<CustomerEntity> entity) {
        return entity.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerEntity toEntity(CustomerDTO dto) {
        return CustomerEntity.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }
}
