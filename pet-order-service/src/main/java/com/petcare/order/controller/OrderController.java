package com.petcare.order.controller;

import com.petcare.common.api.ApiResponse;
import com.petcare.common.dto.OrderDTO;
import com.petcare.common.dto.UserDTO;
import com.petcare.order.client.UserClient;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final UserClient userClient;

    public OrderController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/{id}")
    public ApiResponse<OrderDTO> getOrder(@PathVariable Long id) {
        ApiResponse<UserDTO> userResponse = userClient.getUser(1L);
        OrderDTO order = new OrderDTO(id, "pet grooming package", new BigDecimal("99.00"), userResponse.getData());
        return ApiResponse.ok(order);
    }
}
