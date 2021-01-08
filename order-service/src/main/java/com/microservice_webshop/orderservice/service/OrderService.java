package com.microservice_webshop.orderservice.service;

import com.microservice_webshop.orderservice.VO.Customer;
import com.microservice_webshop.orderservice.VO.Product;
import com.microservice_webshop.orderservice.VO.ResponseTemplateVO;
import com.microservice_webshop.orderservice.entity.OrderE;
import com.microservice_webshop.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public OrderE addOrder(OrderE order) {
        return orderRepository.save(order);
    }

/*    public ResponseTemplateVO getCustomerByOrderId(Long orderId) {


    }

    public ResponseTemplateVO getOrderByCustomerId(Long customerId) {
    }*/

    public ResponseTemplateVO getOrderWithCustomer(Long orderId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        OrderE order = orderRepository.findOrderByOrderId(orderId);

        //Making a REST call to the other microservices, passing the customerId from the order
        Customer customer =
                restTemplate.getForObject("http://CUSTOMER-SERVICE/customer/" + order.getCustomerId()
                        , Customer.class);
        Product product =
                restTemplate.getForObject("http://PRODUCT-SERVICE/product/" + order.getProductId()
                , Product.class);

        //Setting views
        vo.setOrder(order);
        vo.setProduct(product);
        vo.setCustomer(customer);

        return vo;
    }
}
