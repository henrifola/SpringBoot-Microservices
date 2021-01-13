package com.microservice_webshop.productservice.DTO;

import lombok.Data;

@Data
public class ProductDTO {
    private Long productId;
    private String productName;
    private Integer productStock;
    private Double productPrice;
}
