package com.petcare.user.controller;

import com.petcare.common.api.ApiResponse;
import com.petcare.common.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public ApiResponse<UserDTO> getUser(@PathVariable Long id) {
        UserDTO user = new UserDTO(id, "pet-owner-" + id, "13800000000");
        return ApiResponse.ok(user);
    }
}
