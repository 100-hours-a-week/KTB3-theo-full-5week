package com.example.KTB_4WEEK.Interceptor.config;

import com.example.KTB_4WEEK.Interceptor.auth.TokenAuthInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final TokenAuthInterceptor tokenAuthInterceptor;

    public WebMvcConfig(TokenAuthInterceptor tokenAuthInterceptor) {
        this.tokenAuthInterceptor = tokenAuthInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenAuthInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/auth/**",
//                        "/user",
//                        "/user/nickname/double-check",
//                        "/user/email/double-check",
//                        "/swagger-ui/**");
    }
}
