package com.example.delivery_example.web.controller;

import com.example.delivery_example.web.dto.CustomerDTO;
import com.example.delivery_example.web.service.CustomerService;
import com.example.delivery_example.web.url.UrlContainer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;

@RestController
@Api(tags = "Zákazník")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation("Registrace uživatele")
    @PostMapping(path = UrlContainer.REGISTRATION_USER)
    public ResponseEntity<CustomerDTO> createUser(@RequestBody CustomerDTO dto) {
        CustomerDTO save = customerService.save(dto);
        return ResponseEntity.ok(save);
    }
}
