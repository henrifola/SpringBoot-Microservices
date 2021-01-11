package com.microservice_webshop.orderservice.VO;

import com.microservice_webshop.orderservice.entity.OrderE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Customer customer;
    private List<Product> product;
    private List<OrderE> order;

}
