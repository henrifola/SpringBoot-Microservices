package com.microservice_webshop.orderservice.VO;

import com.microservice_webshop.orderservice.entity.OrderE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Customer customer;
    private Product product;
    private OrderE order;

}
