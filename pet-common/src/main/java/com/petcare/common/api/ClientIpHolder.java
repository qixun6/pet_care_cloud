package com.petcare.common.api;

/**
 * 使用 ThreadLocal 存储当前请求的客户端真实IP
 * 作用：确保负载均衡器在任何线程环境下都能拿到 IP
 */
public class ClientIpHolder {
    private static final ThreadLocal<String> IP_CONTEXT = new ThreadLocal<>();

    public static void setIp(String ip) {
        IP_CONTEXT.set(ip);
    }

    public static String getIp() {
        return IP_CONTEXT.get();
    }

    public static void clear() {
        IP_CONTEXT.remove();
    }
}