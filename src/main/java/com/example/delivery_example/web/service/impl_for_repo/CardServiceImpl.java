package com.example.delivery_example.web.service.impl_for_repo;

import com.example.delivery_example.store.entity.CardEntity;
import com.example.delivery_example.store.entity.CustomerEntity;
import com.example.delivery_example.store.repository.CardRepository;
import com.example.delivery_example.store.repository.CustomerRepository;
import com.example.delivery_example.web.dto.CardDTO;
import com.example.delivery_example.web.dto.mapper.CardMapper;
import com.example.delivery_example.web.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CustomerRepository customerRepository;
    private final CardMapper cardMapper;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, CustomerRepository customerRepository,
                           CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.customerRepository = customerRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public CardDTO createCard(long userId, CardDTO dto) {
        CardEntity cardEntity = CardEntity.builder()
                .nameOwner(dto.getNameOwner())
                .cardNumber(dto.getCvv())
                .expiryDate(dto.getExpiryDate())
                .balance(BigDecimal.valueOf(100))
                .cvv(dto.getCvv())
                .build();
        CardEntity save = cardRepository.save(cardEntity);
        CustomerEntity customerEntity = customerRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("not found"));
        customerEntity.setCardEntities(Set.of(save));
        return cardMapper.toDto(cardEntity);
    }
}
