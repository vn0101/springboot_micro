package com.example.demo1.service;

import com.example.demo1.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CustomerService {

    public CustomerDTO getCustomerById(UUID id);
}
