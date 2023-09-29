package com.example.delivery_example.web.dto.mapper;

import com.example.delivery_example.store.entity.CardEntity;
import com.example.delivery_example.web.dto.CardDTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardMapperImpl implements CardMapper {

    @Override
    public CardDTO toDto(CardEntity entity) {
        return CardDTO.builder()
                .id(entity.getId())
                .nameOwner(entity.getNameOwner())
                .cardNumber(entity.getCardNumber())
                .expiryDate(entity.getExpiryDate())
                .cvv(entity.getCvv())
                .balance(entity.getBalance())
                .build();
    }

    @Override
    public List<CardDTO> toDto(List<CardEntity> entity) {
        return entity.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CardEntity toEntity(CardDTO dto) {
        return CardEntity.builder()
                .id(dto.getId())
                .nameOwner(dto.getNameOwner())
                .cardNumber(dto.getCardNumber())
                .expiryDate(dto.getExpiryDate())
                .cvv(dto.getCvv())
                .balance(dto.getBalance())
                .build();
    }
}
