package com.petcare.order.config;

import com.petcare.common.api.ClientIpHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求入口过滤器：从 HTTP 请求中提取真实 IP 并存入 ThreadLocal
 * 后续所有同线程操作（包括 Feign 调用）都可以通过 ClientIpHolder 获取
 */
@Component
public class ClientIpFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            // 1. 尝试从代理头获取
            String ip = request.getHeader("X-Forwarded-For");
            if (ip != null && !ip.isEmpty()) {
                ip = ip.split(",")[0].trim(); // 取第一个 IP（真实客户端 IP）
            } else {
                // 2. 备用：尝试 X-Real-IP
                ip = request.getHeader("X-Real-IP");
            }
            // 3. 最终兜底：直接使用建立连接的对端 IP
            if (ip == null || ip.isEmpty()) {
                ip = request.getRemoteAddr();
            }
            // 存入 ThreadLocal
            ClientIpHolder.setIp(ip);
//            System.out.println("Request from IP: " + ip); // 日志查看真实 IP

            // 继续执行过滤器链
            filterChain.doFilter(request, response);
        } finally {
            // 请求结束时必须清理，防止内存泄漏
            ClientIpHolder.clear();
        }
    }
}