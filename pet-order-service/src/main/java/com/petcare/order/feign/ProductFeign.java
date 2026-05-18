package com.petcare.order.feign;

import com.petcare.common.api.ApiResponse;
import com.petcare.common.dto.ProductDTO;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pet-product-service", path = "/products")
public interface ProductFeign {

    /*@GetMapping("/{id}") //
    ApiResponse<ProductDTO> getProduct(@PathVariable("id") Long id);*/

    // 使用feign原生注解
    @RequestLine("GET /{id}")
    ApiResponse<ProductDTO> getProduct(@Param("id") Long id);
}
