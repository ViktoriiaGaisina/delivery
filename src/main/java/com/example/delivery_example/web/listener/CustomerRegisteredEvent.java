package com.example.delivery_example.web.listener;

import com.example.delivery_example.store.entity.CustomerEntity;
import org.springframework.context.ApplicationEvent;

public class CustomerRegisteredEvent extends ApplicationEvent {
    private final CustomerEntity customer;

    public CustomerRegisteredEvent(Object source, CustomerEntity customer) {
        super(source);
        this.customer = customer;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }
}
