package org.example.exogestionbibliotheque.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(org.example.exogestionbibliotheque.annotation.AnnotationLog)")
    public void performancePointCut() {

    }
    @Before("performancePointCut()")
    public void logBefore() {

        System.out.println("avant la méthode");
    }
    @After("performancePointCut()")
    public void logAfter(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("après la méthode" + joinPoint.getSignature().getName() + Arrays.stream(args).toList());
    }

    @AfterReturning(value = "performancePointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("retour de la méthode" + result);
    }

//    @AfterThrowing(value = "execution(* org.example.exogestionbibliotheque.service.*.*(..))", throwing)


}
