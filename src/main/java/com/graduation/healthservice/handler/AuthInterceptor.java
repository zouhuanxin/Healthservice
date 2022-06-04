package com.graduation.healthservice.handler;

import com.graduation.healthservice.tools.RedisUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class AuthInterceptor implements HandlerInterceptor {
    private RedisUtils redisUtils;

    public AuthInterceptor(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String token = request.getHeader("token");
        if (IsEmpty(token)) {
            response.getWriter().print("{\"code\":400,\"message\":\"用户未登录，请登录后操作！\"}");
            return false;
        }
        Object loginStatus = redisUtils.get(token);
        if (Objects.isNull(loginStatus)) {
            response.getWriter().print("{\"code\":400,\"message\":\"token错误！\"}");
            return false;
        }
        return true;
    }

    boolean IsEmpty(String str) {
        if (str == null){
            return true;
        }
        if (str.equals("") || str.length() == 0){
            return true;
        }
        return false;
    }
}
