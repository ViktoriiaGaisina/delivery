package com.example.delivery_example.web.service.mail;

import com.example.delivery_example.store.entity.CustomerEntity;

public interface CustomerEventPublisher {
    void publishCustomerRegisteredEvent(CustomerEntity customer);
}
