package com.petcare.product.controller;

import com.petcare.common.api.ApiResponse;
import com.petcare.common.dto.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public ApiResponse<ProductDTO> getProduct(@PathVariable Long id) {
        ProductDTO product = new ProductDTO(id, "金毛", BigDecimal.valueOf(1399));
        return ApiResponse.ok(product);
    }
}
