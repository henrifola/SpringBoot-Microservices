package com.microservice_webshop.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Basket {
   // @AttributeOverrides({
   //         @AttributeOverride(name="orderId", column = @Column(orderId))
   //         @AttributeOverride(name="productId", column = @Column(name = "PRODUCT_ID"))

   // })


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long basketEntry;
    private Long orderId;
    private Long productId;
    private Integer quantity;
}

