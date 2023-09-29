package com.example.delivery_example.web.service;


import com.example.delivery_example.web.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO create(long userId, List<Long> dishIds);
}
