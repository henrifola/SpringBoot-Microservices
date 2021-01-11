package com.microservice_webshop.orderservice.controller;

import com.microservice_webshop.orderservice.VO.ResponseTemplateVO;
import com.microservice_webshop.orderservice.entity.OrderE;
import com.microservice_webshop.orderservice.entity.Basket;
import com.microservice_webshop.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public OrderE createOrder(@RequestBody OrderE order){
        log.info("Created basket for customer id " + order.getCustomerId());
        return orderService.addOrder(order);
    }
    @PostMapping("/basket/")
    public OrderE addToBasket(@RequestBody Basket orderProduct){
        log.info("Adding items to basket");
        return orderService.addToBasket(orderProduct);
    }

    @GetMapping("/customer/{id}")
    public ResponseTemplateVO getOrdersByCustomerId(@PathVariable("id") Long customerId){
        log.info("Getting all orders with customer and product info by customer id " + customerId);
        return orderService.getOrderByCustomerId(customerId);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getOrderInfoById(@PathVariable("id") Long orderId){
        log.info("Getting order with customer and product info by order id " + orderId);
        return orderService.getOrderInfoByOrderId(orderId);
    }


    @GetMapping("/")
    public List<OrderE> getAllOrders(){
        return orderService.getAllOrders();
    }




}
