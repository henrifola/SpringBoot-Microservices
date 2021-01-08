package com.microservice_webshop.productservice.repository;

import com.microservice_webshop.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByProductId(Long productId);
}
