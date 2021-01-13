package com.microservice_webshop.productservice.controller;

import com.microservice_webshop.productservice.DTO.ProductDTO;
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
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO){
        return productService.addProduct(productDTO);
    }

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable("id") Long productId){
        return productService.findProductById(productId);
    }
    @GetMapping("/")
    @ResponseBody
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProductsDTO();
    }
    @GetMapping("/stock/{id}/{quantity}")
    public ProductDTO updateStock(@PathVariable("quantity") Integer quantity, @PathVariable("id") Long id){
        return productService.updateStock(quantity, id);
    }
}
