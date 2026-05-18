package com.petcare.order.controller;

import com.petcare.common.api.ApiResponse;
import com.petcare.common.dto.OrderDTO;
import com.petcare.common.dto.ProductDTO;
import com.petcare.common.dto.UserDTO;
import com.petcare.order.feign.ProductFeign;
import com.petcare.order.feign.UserFeign;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private ProductFeign productFeign;

    @GetMapping("/{id}")
    public ApiResponse<OrderDTO> getOrder(@PathVariable Long id) {
        ApiResponse<UserDTO> userResponse = userFeign.getUser(1L);
        ApiResponse<ProductDTO> productResponse = productFeign.getProduct(1L);
        OrderDTO order = new OrderDTO(
                id,
                "pet grooming package",
                new BigDecimal("99.00"),
                userResponse.getData(),
                productResponse.getData()
        );
        return ApiResponse.ok(order);
    }
}
