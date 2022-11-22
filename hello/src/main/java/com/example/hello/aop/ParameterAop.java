package com.example.hello.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class ParameterAop {

    @Pointcut("execution(* com.example.hello.controller..*.*(..))")
    private void pointCut() {}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature =
                (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        log.warn(method.getName());

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.warn("Type : " + arg.getClass().getSimpleName());
            log.warn("Value : " + arg);
        }
    }

    @AfterReturning(value = "pointCut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        log.warn("return Obj : " + returnObj);
    }
}
