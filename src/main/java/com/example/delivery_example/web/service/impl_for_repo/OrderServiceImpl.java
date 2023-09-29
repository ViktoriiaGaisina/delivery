package com.example.delivery_example.web.service.impl_for_repo;

import com.example.delivery_example.store.entity.CustomerEntity;
import com.example.delivery_example.store.entity.DishEntity;
import com.example.delivery_example.store.entity.OrderEntity;
import com.example.delivery_example.store.entity.StatusOrderEntity;
import com.example.delivery_example.store.repository.OrderRepository;
import com.example.delivery_example.store.repository.StatusRepository;
import com.example.delivery_example.web.dto.CustomerDTO;
import com.example.delivery_example.web.dto.OrderDTO;
import com.example.delivery_example.web.dto.mapper.CustomerMapper;
import com.example.delivery_example.web.dto.mapper.DishMapper;
import com.example.delivery_example.web.dto.mapper.OrderMapper;
import com.example.delivery_example.web.service.CustomerService;
import com.example.delivery_example.web.service.DishService;
import com.example.delivery_example.web.service.OrderBillingService;
import com.example.delivery_example.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.delivery_example.web.utils.OrderNumberGenerator.generateOrderNumber;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final DishService dishService;
    private final CustomerService customerService;
    private final OrderBillingService orderBillingService;
    private final DishMapper dishMapper;
    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;

    private final StatusRepository statusRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, DishService dishService,
                            CustomerService customerService, OrderBillingService orderBillingService,
                            DishMapper dishMapper, OrderMapper orderMapper, CustomerMapper customerMapper,
                            StatusRepository statusRepository) {
        this.orderRepository = orderRepository;
        this.dishService = dishService;
        this.customerService = customerService;
        this.orderBillingService = orderBillingService;
        this.dishMapper = dishMapper;
        this.orderMapper = orderMapper;
        this.customerMapper = customerMapper;
        this.statusRepository = statusRepository;
    }

    @Transactional
    public OrderDTO create(long userId, List<Long> dishIds) {
        List<DishEntity> dishEntities = dishIds.stream()
                .map(dishService::getDishEntityById)
                .collect(Collectors.toList());
        BigDecimal totalAmount = orderBillingService.calculateTotalAmount(dishEntities);
        StatusOrderEntity status = statusRepository.findByName("očekává platbu").get();
        OrderEntity builder = OrderEntity.builder()
                .numberOfOrder(generateOrderNumber())
                .dishEntities(dishEntities)
                .created(Instant.now())
                .statusOrderEntity(status)
                .price(totalAmount)
                .build();
        OrderEntity saveOrder = orderRepository.save(builder);
        CustomerDTO customerDTO = customerService.getCustomerById(userId);
        CustomerEntity customerEntity = customerMapper.toEntity(customerDTO);
        customerEntity.setOrderEntityList(List.of(builder));
        customerService.save(customerEntity);
        OrderDTO orderDto = orderMapper.toDto(saveOrder);
        return orderDto;
    }
}
