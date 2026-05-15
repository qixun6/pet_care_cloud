package com.petcare.order;

import com.petcare.order.config.LoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClientConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
// 自定义负载均衡策略
@LoadBalancerClient(name = "pet-user-service", configuration = LoadBalancerConfig.class)
//@LoadBalancerClients({
//        @LoadBalancerClient(name = "serviceA", configuration = LoadBalancerConfig.class),
//        @LoadBalancerClient(name = "serviceB", configuration = LoadBalancerConfig.class)
//})
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
