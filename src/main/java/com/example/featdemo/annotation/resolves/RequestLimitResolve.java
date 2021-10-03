package com.example.featdemo.annotation.resolves;

import com.example.featdemo.annotation.RequestLimit;
import com.example.featdemo.exception.LimitRequestException;
import com.example.featdemo.util.RedisUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;

@Aspect
@Component
public class RequestLimitResolve {
    @Pointcut("@annotation(com.example.featdemo.annotation.RequestLimit)")
    private void cut() {
    }

    @Before("cut()")
    public void requestLimit(JoinPoint joinPoint) throws LimitRequestException, Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes != null ? attributes.getRequest() : null;
        if (request == null) {
            System.out.println("null");
        } else {
            String redisKey = "limit:" + request.getRequestURI() + "-" + request.getMethod() + ":" + getIpAddr(request);
            Integer count = (Integer) RedisUtil.get(redisKey);
            RequestLimit annotation = getAnnotation(joinPoint);
            long timeout = annotation.timeout();
            int limit = annotation.limit();
            if (count == null) {
                count = 0;
            }
            else{
                if (count > limit) {
                    throw new LimitRequestException("您的请求过于频繁，请稍后再试");
                }
            }
            count++;
            RedisUtil.set(redisKey, ++count, timeout);
        }
    }

    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

    private RequestLimit getAnnotation(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(RequestLimit.class);
        }
        return null;
    }
}
