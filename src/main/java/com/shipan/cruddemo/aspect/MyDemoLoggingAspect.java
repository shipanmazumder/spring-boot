package com.shipan.cruddemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Around("execution(* com.shipan.cruddemo.service.*.getFortune() )")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        String method=proceedingJoinPoint.getSignature().toLongString();
        System.out.println(method);
        long begin=System.currentTimeMillis();

        Object result=proceedingJoinPoint.proceed();

        long end=System.currentTimeMillis();
        long duration=end-begin;
        System.out.println("\n======Duration: "+(duration/1000.0)+" seconds");
        return result;
    }
    @Before("execution(public void addAccount() )")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
