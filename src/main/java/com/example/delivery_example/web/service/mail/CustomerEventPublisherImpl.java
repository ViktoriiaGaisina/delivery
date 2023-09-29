package com.example.delivery_example.web.service.mail;

import com.example.delivery_example.store.entity.CustomerEntity;
import com.example.delivery_example.web.listener.CustomerRegisteredEvent;
import com.example.delivery_example.web.service.mail.CustomerEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
@Component
public class CustomerEventPublisherImpl implements CustomerEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public CustomerEventPublisherImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publishCustomerRegisteredEvent(CustomerEntity customer) {
        eventPublisher.publishEvent(new CustomerRegisteredEvent(this, customer));
    }
}
