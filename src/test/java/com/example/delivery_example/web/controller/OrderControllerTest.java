package com.example.delivery_example.web.controller;


import com.example.delivery_example.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestConfig.class)
@AutoConfigureMockMvc
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

//    @Test
//    void createOrderTest() throws Exception {
//        long customerId = 1L;
//        List<Long> dishIds = Arrays.asList(1L, 2L, 3L);
//        mockMvc.perform(MockMvcRequestBuilders.post("/rest/create-order/{id}")
//    }
}