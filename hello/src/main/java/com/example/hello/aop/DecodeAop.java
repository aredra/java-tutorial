package com.example.hello.aop;

import com.example.hello.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.hello.controller..*.*(..))")
    private void pointCut() {}

    @Pointcut("@annotation(com.example.hello.annotation.Decode)")
    private void enableDecode() {}

    @Before("pointCut() && enableDecode()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof User) {
                User user = (User) arg;
                String base64Email = Base64.getEncoder().encodeToString(user.getEmail().getBytes());
                user.setEmail(base64Email);
            }
            log.warn("Type : " + arg.getClass().getSimpleName());
            log.warn("Value : " + arg);
        }
    }

    @AfterReturning(value = "pointCut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        User user = null;
        log.warn("return Obj : " + returnObj);
        if (returnObj instanceof User) {
            user = (User) returnObj;
            String base64Email = user.getEmail();
            user.setEmail(new String(Base64.getDecoder().decode(base64Email), StandardCharsets.UTF_8));
        }
        log.warn("ReturnObj : " + user);
    }
}
