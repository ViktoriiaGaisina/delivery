package com.example.delivery_example.web.handler;

import com.example.delivery_example.web.exception.PaymentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class PaymentExceptionHandler {

    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<String> handleException(PaymentException e) {
        log.error(e.getMessage());
        return ResponseEntity.ok(e.getMessage());
    }
}
