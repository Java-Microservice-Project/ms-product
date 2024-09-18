package com.example.ms_product.controller;


import com.example.ms_product.model.request.SaveProductDto;
import com.example.ms_product.model.response.ProductResponseDto;
import com.example.ms_product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(productService.getResponseById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@Valid @RequestBody SaveProductDto dto) {
        productService.saveProduct(dto);
        return ResponseEntity.status(CREATED).build();
    }

    @PostMapping("reduce/{id}")
    public ResponseEntity<Void> reduceProductCount(@PathVariable Long id, @RequestParam Integer count) {
        productService.reduceProductCount(id, count);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
