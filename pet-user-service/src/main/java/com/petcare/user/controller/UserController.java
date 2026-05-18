package com.petcare.user.controller;

import com.petcare.common.api.ApiResponse;
import com.petcare.common.dto.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RefreshScope
public class UserController {

    @Value("${server.port}")
    private String port;

    @Value("${user.name}")
    private String name;

    @GetMapping("/{id}")
    public ApiResponse<UserDTO> getUser(@PathVariable Long id) {
        UserDTO user = new UserDTO(id, "pet-owner-" + id + "-" + port, "13800000000");
        return ApiResponse.ok(user);
    }

    @GetMapping("/refresh/{id}")
    public ApiResponse<UserDTO> getRefreshScopeUser(@PathVariable Long id) {
        UserDTO user = new UserDTO(id, name, "13800000000");
        return ApiResponse.ok(user);
    }
}
