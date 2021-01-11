package com.microservice_webshop.orderservice.service;

import com.microservice_webshop.orderservice.VO.Customer;
import com.microservice_webshop.orderservice.VO.Product;
import com.microservice_webshop.orderservice.VO.ResponseTemplateVO;
import com.microservice_webshop.orderservice.entity.OrderE;
import com.microservice_webshop.orderservice.entity.Basket;
import com.microservice_webshop.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public OrderE addOrder(OrderE order) {

        return orderRepository.save(order);
    }


    public OrderE addToBasket(Basket basket) {
        OrderE order = orderRepository.findOrderByOrderId(basket.getOrderId());
        Set<Basket> addBasket = order.getBasket();
        addBasket.add(basket);
        order.setBasket(addBasket);
        order.setTotal(getProduct(basket.getProductId()).getProductPrice() * basket.getQuantity());
        updateStock(basket.getProductId(), basket.getQuantity());
        return orderRepository.save(order);
    }
    private void updateStock(Long productId, Integer quantity){
        Product product =
                restTemplate.getForObject("http://PRODUCT-SERVICE/product/stock/" + productId + "/" + quantity
                        , Product.class);

        log.info(" " + product.getProductStock());

    }


    public ResponseTemplateVO getOrderInfoByOrderId(Long orderId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        OrderE order = orderRepository.findOrderByOrderId(orderId);

        List<Product> products = new ArrayList<Product>();
        for (Basket b : order.getBasket()) {
            products.add(getProduct(b.getProductId()));
        }

        //Setting views
        vo.setOrder(Collections.singletonList(order));
        vo.setProduct(products);
        vo.setCustomer(getCustomer(order.getCustomerId()));

        return vo;
    }


    public List<OrderE> getAllOrders() {
        return orderRepository.findAll();
    }

    public ResponseTemplateVO getOrderByCustomerId(Long customerId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        List<OrderE> order = orderRepository.findOrderByCustomerId(customerId);
        List<Product> products = new ArrayList<Product>();

        for (OrderE o : order) {
            for (Basket b : o.getBasket()) {
                products.add(getProduct(b.getProductId()));
            }
        }

        vo.setOrder(order);
        vo.setCustomer(getCustomer(customerId));
        vo.setProduct(products);
        return vo;
    }

    private Customer getCustomer(Long customerId){
        //Making a REST call to the other microservices, passing the customerId from the order
        Customer customer =
                restTemplate.getForObject("http://CUSTOMER-SERVICE/customer/" + customerId
                        , Customer.class);
        return customer;
    }

    private Product getProduct(Long productId){
        Product product =
                restTemplate.getForObject("http://PRODUCT-SERVICE/product/" + productId
                        , Product.class);
        return product;
    }
}
