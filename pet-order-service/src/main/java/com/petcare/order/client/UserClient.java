package com.petcare.order.client;

import com.petcare.common.api.ApiResponse;
import com.petcare.common.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pet-user-service")
public interface UserClient {
    @GetMapping("/users/getUser/{id}")
    ApiResponse<UserDTO> getUser(@PathVariable("id") Long id);
}
