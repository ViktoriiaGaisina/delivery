package com.example.delivery_example.web.service;

public interface PaymentService {

    boolean toPay(long orderId, long cardId);
}

