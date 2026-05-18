package com.petcare.order.interceptor.feign;

import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomFeignInterceptor implements feign.RequestInterceptor {

    Logger logger = LoggerFactory.getLogger(CustomFeignInterceptor.class);

    @Override
    public void apply(RequestTemplate template) {
        // 加日志
        logger.info("Feign 拦截器");

        // 修改请求头
        template.header("X-Custom-Header", "Custom Header");
        template.query("X-Custom-Query", "Custom Query");
        template.uri("/9");
    }
}
