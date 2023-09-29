package com.example.delivery_example.web.controller;

import com.example.delivery_example.web.dto.OrderDTO;
import com.example.delivery_example.web.service.OrderService;
import com.example.delivery_example.web.url.UrlContainer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Objednávka")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation("Vytvořit objednávku")
    @PostMapping(path = UrlContainer.CREATE_ORDER)
    public ResponseEntity<OrderDTO> createOrder(@PathVariable long id, @RequestParam List<Long> dishIds) {
        return ResponseEntity.ok(orderService.create(id, dishIds));
    }
}
