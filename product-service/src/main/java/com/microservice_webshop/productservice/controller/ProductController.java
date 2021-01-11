package com.microservice_webshop.productservice.controller;

import com.microservice_webshop.productservice.entity.Product;
import com.microservice_webshop.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable("id") Long productId){
        return productService.findProductById(productId);
    }
    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/stock/{id}/{quantity}")
    public Product updateStock(@PathVariable("quantity") Integer quantity, @PathVariable("id") Long id){
        return productService.updateStock(quantity, id);
    }
}
