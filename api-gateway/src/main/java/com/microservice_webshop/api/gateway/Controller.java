package com.microservice_webshop.api.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/orderFallBack")
    public String orderFallBack(){
        return "Order service fallback";
    }

    @GetMapping("/productFallBack")
    public String productFallBack(){
        return "Product service fallback";
    }

    @GetMapping("/customerFallBack")
    public String customerFallBack(){
        return "Customer service fallback";
    }

}
