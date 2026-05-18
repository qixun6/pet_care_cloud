package com.petcare.order.config;

import feign.Contract;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局配置：使用@Configuration 会将配置作用在所有的服务提供方
 * 局部配置：1. 通过配置类。如果只想针对某一个服务进行配置，就不要加@Configuration
 *         2. 通过yml配置文件
 */
//@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 修改契约配置，支持feign原生注解
     * @return
     */
    /*@Bean
    public Contract feignContract() {
        return new Contract.Default();
    }*/

    /**
     * 配置连接超时时间和读取超市时间
     * @return
     */
    /*@Bean
    public Request.Options feignRequestOptions() {
        return new Request.Options(5 * 1000, 10 * 1000);
    }*/
}
