package com.example.delivery_example.web.listener;

import com.example.delivery_example.store.entity.CustomerEntity;
import com.example.delivery_example.web.service.mail.MessageSender;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerRegisteredEventListener {
    private final MessageSender messageSender;

    public CustomerRegisteredEventListener(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @EventListener
    public void handleCustomerRegisteredEvent(CustomerRegisteredEvent registeredEvent) {
        CustomerEntity customer = registeredEvent.getCustomer();
        String email = customer.getEmail();
        messageSender.sendMessage(email);
    }
}
