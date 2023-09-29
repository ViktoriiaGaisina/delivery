package com.example.delivery_example.web.service;

import com.example.delivery_example.web.dto.CardDTO;

public interface CardService {

    CardDTO createCard(long userId, CardDTO dto);
}
