package com.microservice_webshop.orderservice.repository;

import com.microservice_webshop.orderservice.entity.OrderE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderRepository extends JpaRepository<OrderE, Long> {
    OrderE findOrderByOrderId(Long orderId);
}
