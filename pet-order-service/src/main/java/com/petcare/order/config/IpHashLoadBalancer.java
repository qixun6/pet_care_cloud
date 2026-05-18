package com.petcare.order.config;

import com.petcare.common.api.ClientIpHolder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.cloud.loadbalancer.core.*;
import reactor.core.publisher.Mono;
import java.util.List;

public class IpHashLoadBalancer implements ReactorServiceInstanceLoadBalancer {

    private final ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;
    private final String serviceId;

    public IpHashLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider,
                              String serviceId) {
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierProvider;
        this.serviceId = serviceId;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        ServiceInstanceListSupplier supplier = serviceInstanceListSupplierProvider.getIfAvailable();
        if (supplier == null) {
            return Mono.just(new EmptyResponse());
        }
        return supplier.get(request).next().map(instances -> {
            if (instances.isEmpty()) {
                return new EmptyResponse();
            }

            // ★★★ 直接从 ThreadLocal 获取真实 IP，不再解析 RequestData
            String clientIp = ClientIpHolder.getIp();
            if (clientIp == null || clientIp.isEmpty()) {
                clientIp = "unknown"; // 非 Web 线程或未设置时使用固定值
            }

            ServiceInstance selected = ipHash(clientIp, instances);
//            System.out.println("Client IP: " + clientIp + " -> Selected: " + selected.getHost() + ":" + selected.getPort());
            return new DefaultResponse(selected);
        });
    }

    private ServiceInstance ipHash(String key, List<ServiceInstance> instances) {
        int hash = Math.abs(key.hashCode());
        int index = hash % instances.size();
        return instances.get(index);
    }
}