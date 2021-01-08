package com.microservice_webshop.orderservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long customerId;
    private String firstName;
    private String lastName;
    private String customerEmail;
}