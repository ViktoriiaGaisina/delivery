package com.example.delivery_example.web.service.impl_for_repo;

import com.example.delivery_example.store.entity.CardEntity;
import com.example.delivery_example.store.entity.OrderEntity;
import com.example.delivery_example.store.entity.StatusOrderEntity;
import com.example.delivery_example.store.repository.CardRepository;
import com.example.delivery_example.store.repository.CustomerRepository;
import com.example.delivery_example.store.repository.OrderRepository;
import com.example.delivery_example.store.repository.StatusRepository;
import com.example.delivery_example.web.dto.mapper.OrderMapper;
import com.example.delivery_example.web.exception.PaymentException;
import com.example.delivery_example.web.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class PaymentServiceDebitCardImpl implements PaymentService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepository;
    private final StatusRepository statusRepository;
    private final CardRepository cardRepository;

    @Autowired
    public PaymentServiceDebitCardImpl(OrderRepository orderRepository, CardRepository cardRepository,
                                       OrderMapper orderMapper, CustomerRepository customerRepository,
                                       StatusRepository statusRepository) {
        this.orderRepository = orderRepository;
        this.cardRepository = cardRepository;
        this.orderMapper = orderMapper;
        this.customerRepository = customerRepository;
        this.statusRepository = statusRepository;
    }

    @Transactional
    public boolean toPay(long orderId, long cardId) {
        OrderEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("order not found"));
        CardEntity card = cardRepository.findById(cardId)
                .orElseThrow(() -> new NoSuchElementException("card not found"));
        StatusOrderEntity statusOrder = statusRepository.findByName("заказ готовится")
                .orElseThrow(() -> new NoSuchElementException("status not found"));
        BigDecimal debit;
        LocalDateTime currentDateTime = LocalDateTime.now();
        if (card.getExpiryDate().isBefore(currentDateTime)) {
            throw new PaymentException("The card has expired.");
        }
        BigDecimal price = order.getPrice();
        BigDecimal balance = card.getBalance();
        if (price.compareTo(balance) <= 0) {
            debit = balance.subtract(price);
            card.setBalance(debit);
            cardRepository.save(card);
            order.setStatusOrderEntity(statusOrder);
            orderRepository.save(order);
            return true;
        }
        return false;
    }
}
