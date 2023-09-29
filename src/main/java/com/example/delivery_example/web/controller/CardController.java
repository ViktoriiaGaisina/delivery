package com.example.delivery_example.web.controller;

import com.example.delivery_example.web.dto.CardDTO;
import com.example.delivery_example.web.service.CardService;
import com.example.delivery_example.web.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Platební karta")
public class CardController {
    private final CardService cardService;
    private final PaymentService paymentService;

    @Autowired
    public CardController(CardService cardService, PaymentService paymentService) {
        this.cardService = cardService;
        this.paymentService = paymentService;
    }

    @ApiOperation("Registrovat kartu")
    @PostMapping("/create/card-customer/{customer_id}")
    public ResponseEntity<CardDTO> createCard(@PathVariable("customer_id") Long customerId, @RequestBody CardDTO dto) {
        CardDTO cardDTO = cardService.createCard(customerId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardDTO);
    }

    @ApiOperation("Platba debetní kartou")
    @PostMapping("/pay-order/{orderId}/card/{cardId}")
    public ResponseEntity<Boolean> toPay(@PathVariable Long orderId, @PathVariable Long cardId) {
        boolean cardDTO = paymentService.toPay(orderId, cardId);
        return ResponseEntity.ok(cardDTO);
    }
}

