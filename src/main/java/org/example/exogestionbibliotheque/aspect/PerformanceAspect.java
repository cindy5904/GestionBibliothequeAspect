package org.example.exogestionbibliotheque.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public class PerformanceAspect {
    private long executionTime;

    @Before("execution(* org.example.exogestionbibliotheque.service.*.*(..))")
    public void beforeExecution() {
        executionTime = System.currentTimeMillis();
        System.out.println(executionTime);
    }

    @After("execution(* org.example.exogestionbibliotheque.service.*.*(..))")
    public void afterExecution(JoinPoint joinPoint) {
        long timeElapsed = System.currentTimeMillis() - executionTime;
        System.out.println("temps d'execution de la methode :" + joinPoint.getSignature().getName() + "est de :" + timeElapsed);
    }

}
