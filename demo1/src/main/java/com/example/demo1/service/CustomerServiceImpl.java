package com.example.demo1.service;

import com.example.demo1.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID id) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .name("Vindhyaa").build();
    }

    @Override
    public UUID createCustomer(CustomerDTO customerDto) {

       CustomerDTO dto = CustomerDTO.builder().id(customerDto.getId()).name((customerDto.getName())).build();

        
        return dto.getId();
    }
}
