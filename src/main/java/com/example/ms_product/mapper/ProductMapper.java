package com.example.ms_product.mapper;

import com.example.ms_product.dao.entity.ProductEntity;
import com.example.ms_product.model.request.SaveProductDto;
import com.example.ms_product.model.response.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

   ProductEntity buildProductEntity(SaveProductDto dto);

    ProductResponseDto buildProductResponseDto(ProductEntity entity);
}
