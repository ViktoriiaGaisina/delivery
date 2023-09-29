package com.example.delivery_example.web.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderNumberGenerator {
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static String generateOrderNumber() {
        int nextNumber = counter.incrementAndGet();
        return "ORDER_" + nextNumber;
    }
}
