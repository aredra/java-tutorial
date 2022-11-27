package com.example.hello.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/api/aop/*")
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 전처리
        ContentCachingRequestWrapper contentCachingRequestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);

        // 일반적으로 한번 읽으면 컨트롤러에서 다시 읽지 못함 커서 위치가 eof
//        BufferedReader br = contentCachingRequestWrapper.getReader();
//        br.lines().forEach(line -> {
//            log.info("Url : {}, line : {}", url, line);
//        });

        chain.doFilter(contentCachingRequestWrapper, contentCachingResponseWrapper);

        //후처리

        String url = contentCachingRequestWrapper.getRequestURI();
        String reqContent = new String(contentCachingRequestWrapper.getContentAsByteArray());
        log.info("Filter request url: {}, requestBody: {}", url, reqContent);

        String resContent = new String(contentCachingResponseWrapper.getContentAsByteArray());
        int httpStatus = contentCachingResponseWrapper.getStatus();
        // copyBodyToResponse 를 하지 않으면 getContentAsByteArray 가 일으면서 값을 빼버림 body 가 비어버림
        contentCachingResponseWrapper.copyBodyToResponse();
        log.info("Filter response status: {}, responseBody: {}", httpStatus, resContent);

    }
}
