package com.example.delivery_example.web.controller;

import com.example.delivery_example.web.dto.StatusOrderDTO;
import com.example.delivery_example.web.service.StatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Stav objednávky")
public class DeliveryStatusController {
    private final StatusService statusService;

    @Autowired
    public DeliveryStatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @ApiOperation("Získat stav objednávky")
    @GetMapping("/check-status/order/{orderId}")
    public ResponseEntity<StatusOrderDTO> createUser(@PathVariable Long orderId) {
        StatusOrderDTO statusByOrderId = statusService.getStatusByOrderId(orderId);
        return ResponseEntity.ok(statusByOrderId);
    }
}
