package com.example.ms_product.service.serviceImpl;

import com.example.ms_product.dao.entity.ProductEntity;
import com.example.ms_product.dao.repository.ProductRepository;
import com.example.ms_product.exception.NotFoundException;
import com.example.ms_product.model.request.SaveProductDto;
import com.example.ms_product.model.response.ProductResponseDto;
import com.example.ms_product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.ms_product.mapper.ProductMapper.PRODUCT_MAPPER;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void saveProduct(SaveProductDto dto) {
        var entity = PRODUCT_MAPPER.buildProductEntity(dto);
        productRepository.save(entity);
    }

    @Override
    public ProductResponseDto getResponseById(Long id) {
        var entity = fetchProductIfExist(id);
        return PRODUCT_MAPPER.buildProductResponseDto(entity);
    }

    @Override
    public void reduceProductCount(Long id, Integer count) {
        var entity = fetchProductIfExist(id);
        var updatedCount = entity.getCount() - count;
        entity.setCount(updatedCount);
        productRepository.save(entity);
    }

    private ProductEntity fetchProductIfExist(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new NotFoundException(PRODUCT_NOT_FOUND.format(id))
        );
    }
}
