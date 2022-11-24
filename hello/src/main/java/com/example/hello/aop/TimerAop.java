package com.example.hello.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.example.hello.controller..*.*(..))")
    private void pointCut() {}

    @Pointcut("@annotation(com.example.hello.annotation.Timer)")
    private void enableTimer() {}

    @Around("pointCut() && enableTimer()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        log.warn(stopWatch.getTotalTimeSeconds() + "");

        return result;
    }

}
