package com.example.demo1.controller;

import com.example.demo1.model.CustomerDTO;
import com.example.demo1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class CustomerController

{

    @Autowired
    private CustomerService customerService;

//    public CustomerController(){
//
//    }
//
//    public CustomerController(CustomerService customerService){
//        this.customerService = customerService;
//
//    }

    @GetMapping("/customer/{uuid}")

    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("uuid") UUID id){

        return new ResponseEntity<CustomerDTO>(customerService.getCustomerById(id), HttpStatus.OK);



    }
}
