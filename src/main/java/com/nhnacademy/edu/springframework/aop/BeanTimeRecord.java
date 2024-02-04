package com.nhnacademy.edu.springframework.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class BeanTimeRecord {

    @Pointcut("within(com.nhnacademy.edu.springframework..*)")
    public void withinServicePackage(){}

    @Around("withinServicePackage()")
    public Object doBeanTimeRecord(ProceedingJoinPoint pjp) throws Throwable{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = null;
        try{
            result = pjp.proceed();
        }catch (Exception e){
            throw new RuntimeException();
        }finally {
            stopWatch.stop();
            log.info("[{}].[{}] [{}]ms",pjp.getSignature().getDeclaringType(),pjp.getSignature().getName(),stopWatch.getTotalTimeMillis());
        }
        return result;
    }
}
