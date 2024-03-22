package com.example.demo1.service;

import com.example.demo1.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface CustomerService {

    public CustomerDTO getCustomerById(UUID id);
    public UUID createCustomer(CustomerDTO customerDto);
}
