package com.microservice_webshop.orderservice.controller;

import com.microservice_webshop.orderservice.VO.ResponseTemplateVO;
import com.microservice_webshop.orderservice.entity.OrderE;
import com.microservice_webshop.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public OrderE addOrder(@RequestBody OrderE order){
        return orderService.addOrder(order);
    }

    //@GetMapping("/{id}")
    //public Order getOrderById(@PathVariable ){}

    @GetMapping("/{id}")
    public ResponseTemplateVO getOrderWithCustomer(@PathVariable("id") Long orderId){
        log.info("Getting order with customer by order id " + orderId);
        return orderService.getOrderWithCustomer(orderId);
    }

/*    @GetMapping("/cbo/{id}")
    public ResponseTemplateVO getCustomerByOrderId(@PathVariable("id") Long orderId){
        log.info("Getting customer by order id " + orderId);
        return orderService.getCustomerByOrderId(orderId);
    }
    @GetMapping("/obc/{id}")
    public ResponseTemplateVO getOrderByCustomerId(@PathVariable("id") Long customerId){
        log.info("Getting order by customer id " + customerId);
        return orderService.getOrderByCustomerId(customerId);
    }*/


}
