package com.health.config;

import com.health.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CrossConfig implements WebMvcConfigurer {
    //创建Bean对象
    @Bean
    public JWTInterceptor jwtInterceptor() {
        return new JWTInterceptor();
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册指定拦截器
        registry.addInterceptor(jwtInterceptor());
    }

    //配置跨域处理
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
                .maxAge(3600 * 24);
    }
}
