package com.example.hello.interceptor;

import com.example.hello.annotation.Auth;
import com.example.hello.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        URI uri = UriComponentsBuilder.fromUriString(url)
                .query(request.getQueryString()).build().toUri();
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);

        log.info("url: {}, uri: {}", url, uri);

        if (hasAnnotation) {
            // 권한 체크
            String query = uri.getQuery();
            if (query.contains("auth")) {
                return true;
            }
            throw new AuthException();
        }
        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz) {

        // resource js, html
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        return null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz);
    }
}
