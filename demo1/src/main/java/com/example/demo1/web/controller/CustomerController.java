package com.example.demo1.web.controller;

import com.example.demo1.web.model.CustomerDTO;
import com.example.demo1.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class CustomerController

{


    public final CustomerService customerService;

//    public CustomerController(){
//
//    }
//
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;

    }

    @GetMapping("/customerById/{uuid}")

    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("uuid") UUID id){

        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);



    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDTO customerDto){
       UUID uuid = customerService.createCustomer(customerDto);
        HttpHeaders header = new HttpHeaders();
        header.add("uuid",uuid.toString());
        header.add("location","http://localhost:8081/api/customer/"+uuid.toString());
        return new ResponseEntity(header, HttpStatus.CREATED);
    }
    @PutMapping("customerId/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") UUID id, @RequestBody CustomerDTO customerDto){

        CustomerDTO customer = customerService.getCustomerById(id);

        System.out.println(customer);

CustomerDTO updatedCustomer = customer.builder().id(customerDto.getId()).name(customerDto.getName()).build();


UUID newId = updatedCustomer.getId();
String name = updatedCustomer.getName();
return new ResponseEntity(updatedCustomer, HttpStatus.ACCEPTED);

    }

}
