package com.microservice_webshop.customerservice.service;

import com.microservice_webshop.customerservice.entity.Customer;
import com.microservice_webshop.customerservice.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//Logger
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        log.info("addCustomer method");
        return customerRepository.save(customer);
    }

    public Customer findCustomerById(Long customerId){
        log.info("findCustomerById method");
        return customerRepository.findCustomerByCustomerId(customerId);
    }

}
