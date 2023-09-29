package com.example.delivery_example.web.dto.mapper;

import com.example.delivery_example.store.entity.CardEntity;
import com.example.delivery_example.web.dto.CardDTO;

import java.util.List;

public interface CardMapper {

    CardDTO toDto(CardEntity entity);

    List<CardDTO> toDto(List<CardEntity> entity);

    CardEntity toEntity(CardDTO dto);
}
