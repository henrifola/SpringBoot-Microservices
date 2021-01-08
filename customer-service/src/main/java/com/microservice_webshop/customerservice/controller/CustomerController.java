package com.microservice_webshop.customerservice.controller;


import com.microservice_webshop.customerservice.entity.Customer;
import com.microservice_webshop.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//Maps web requests
@RequestMapping("/customer")
//Logger
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    //HTTP POST
    @PostMapping("/")
    public Customer addCustomer(@RequestBody Customer customer){
        log.info("Adding new customer");
        return customerService.addCustomer(customer);
    }
    //HTTP GET
    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable("id") Long customerId){
        log.info("Finding customber by id " + customerId);
        return customerService.findCustomerById(customerId);
    }

}
