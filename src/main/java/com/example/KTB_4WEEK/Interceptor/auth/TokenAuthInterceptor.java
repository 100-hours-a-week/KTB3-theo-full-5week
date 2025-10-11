package com.example.KTB_4WEEK.Interceptor.auth;

import com.example.KTB_4WEEK.exception.auth.UnAuthorizedException;
import com.example.KTB_4WEEK.service.auth.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "application.auth")
public class TokenAuthInterceptor implements HandlerInterceptor {

    private final TokenService tokenService;

    public TokenAuthInterceptor(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);
            long userId = tokenService.verify(token).orElseThrow(() -> new UnAuthorizedException());
            request.setAttribute("userId", userId);
            return true;
        } else {
            throw new UnAuthorizedException();
        }
    }
}
