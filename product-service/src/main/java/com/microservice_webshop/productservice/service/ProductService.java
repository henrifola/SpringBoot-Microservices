package com.microservice_webshop.productservice.service;

import com.microservice_webshop.productservice.DTO.ProductDTO;
import com.microservice_webshop.productservice.entity.Product;
import com.microservice_webshop.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<ProductDTO> getAllProductsDTO(){
        return ((List<Product>) productRepository
                .findAll())
                .stream()
                .map(this::convertProductToDTO).collect(Collectors.toList());
    }

    public ProductDTO addProduct(ProductDTO productDTO){
       Product product = productRepository.save(convertDTOtoProduct(productDTO));
       productDTO.setProductId(product.getProductId());
        return productDTO;
    }

    public ProductDTO findProductById(Long productId){
        return convertProductToDTO(productRepository.findProductByProductId(productId));
    }

    public ProductDTO updateStock(Integer quantity, Long id) {
        Product product = productRepository.findProductByProductId(id);
        product.setProductStock(product.getProductStock() - quantity);
        productRepository.save(product);
        return convertProductToDTO(product);
    }

    private ProductDTO convertProductToDTO(Product product){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(product, ProductDTO.class);
    }
    private Product convertDTOtoProduct(ProductDTO productDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return  modelMapper
                .map(productDTO, Product.class);
    }
}
