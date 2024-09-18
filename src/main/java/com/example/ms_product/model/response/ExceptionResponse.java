package com.example.ms_product.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionResponse {
    Integer status;
    String error;
    String message;
    String path;
    LocalDateTime timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map<String, String> validationErrors;
}