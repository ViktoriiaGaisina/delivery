package com.example.delivery_example.web.service;

import com.example.delivery_example.store.entity.CustomerEntity;
import com.example.delivery_example.web.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO save(CustomerDTO customer);

    CustomerDTO getCustomerById(long id);

    CustomerDTO updateCustomer(long id, CustomerDTO customerDTO);

    List<CustomerDTO> getAll();

    CustomerEntity save(CustomerEntity customer);
}
