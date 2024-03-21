package com.example.demo1.service;

import com.example.demo1.model.CustomerDTO;

import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID id) {
        return new CustomerDTO(UUID.randomUUID(), "Vindhyaa");
    }
}
