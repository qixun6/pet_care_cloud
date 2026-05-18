package com.petcare.order.feign;

import com.petcare.common.api.ApiResponse;
import com.petcare.common.dto.UserDTO;
import com.petcare.order.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pet-user-service", path = "/users", configuration = FeignConfig.class)
public interface UserFeign {
    @GetMapping("/{id}")
    ApiResponse<UserDTO> getUser(@PathVariable("id") Long id);
}
