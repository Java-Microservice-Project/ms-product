package com.example.ms_product.model.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveProductDto {

    @Size(min = 3, max = 50, message = "Name Required - The name must be between 3 and 50 characters.")
    String name;

    @NotNull(message = "Price Required")
    BigDecimal price;

    @NotNull(message = "Count Required")
    Integer count;
}