package com.microservice_webshop.productservice.service;

import com.microservice_webshop.productservice.entity.Product;
import com.microservice_webshop.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){

        return productRepository.save(product);
    }

    public Product findProductById(Long productId){
        Product product1 = productRepository.findProductByProductId(productId);
        product1.getProductId();

        return productRepository.findProductByProductId(productId);
    }

}
