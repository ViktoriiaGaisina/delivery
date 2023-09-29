package com.example.delivery_example.web.service.impl_for_repo;

import com.example.delivery_example.store.entity.CustomerEntity;
import com.example.delivery_example.store.repository.CustomerRepository;
import com.example.delivery_example.web.dto.CustomerDTO;
import com.example.delivery_example.web.dto.mapper.CustomerMapper;
import com.example.delivery_example.web.service.CustomerService;
import com.example.delivery_example.web.service.mail.CustomerEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerEventPublisher customerEventPublisher;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerEventPublisher customerEventPublisher, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerEventPublisher = customerEventPublisher;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO save(CustomerDTO dto) {
        if (!isValidUser(dto)) {
            throw new IllegalArgumentException("Invalid user data");
        }
        CustomerEntity customerEntity = customerMapper.toEntity(dto);
        CustomerEntity entity = customerRepository.save(customerEntity);
        customerEventPublisher.publishCustomerRegisteredEvent(entity);
        return customerMapper.toDto(entity);
    }

    @Override
    public CustomerEntity save(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerMapper.toDto(customerEntities);
    }

    @Override
    public CustomerDTO getCustomerById(long id) {
        return customerRepository.findById(id)
                .map(customerEntity -> customerMapper.toDto(customerEntity))
                .orElseThrow(() -> new RuntimeException());
    }

    @Override
    public CustomerDTO updateCustomer(long id, CustomerDTO customerDTO) {
        CustomerEntity customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());
        CustomerEntity entity = customerRepository.save(customer);
        return customerMapper.toDto(entity);
    }

    private boolean isValidUser(CustomerDTO dto) {
        CustomerEntity customer = customerMapper.toEntity(dto);
        if (dto.getUsername() == null || dto.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Login cannot be empty");
        }
        if (!dto.getUsername().matches("[A-Za-z0-9\\s-]+")) {
            throw new IllegalArgumentException("Name contains invalid characters");
        }
        if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        if (dto.getPassword().length() < 5 || dto.getPassword().length() > 15) {
            throw new IllegalArgumentException("Password length must be between 5 and 15 characters");
        }
        return true;
    }
}

