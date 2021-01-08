package com.microservice_webshop.customerservice.repository;

import com.microservice_webshop.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByCustomerId(Long customerId);

}
