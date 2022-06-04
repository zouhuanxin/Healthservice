package com.graduation.healthservice.handler;

import com.graduation.healthservice.tools.RedisUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class AuthConfig implements WebMvcConfigurer {
    @Resource
    private RedisUtils redisUtils;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration registration = registry.addInterceptor(new AuthInterceptor(redisUtils));
//        registration.addPathPatterns("/**"); //所有路径都被拦截
//        registration.excludePathPatterns(
//                "/health/advertisement/getEffectiveAd",
//                "/health/register/test",
//                "/health/register/login",
//                "/health/register/register",
//                "/health/register/sendsms",
//                "/health/register/verify",
//                "/**/*.html",            //html静态资源
//                "/**/*.js",              //js静态资源
//                "/**/*.css",             //css静态资源
//                "/**/*.woff",
//                "/**/*.ttf"
//        );
    }
}
