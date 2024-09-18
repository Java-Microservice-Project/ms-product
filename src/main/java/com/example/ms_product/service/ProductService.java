package com.example.ms_product.service;

import com.example.ms_product.model.request.SaveProductDto;
import com.example.ms_product.model.response.ProductResponseDto;

public interface ProductService {

    void saveProduct(SaveProductDto dto);

    ProductResponseDto getResponseById(Long id);

    void reduceProductCount(Long id, Integer count);
}
