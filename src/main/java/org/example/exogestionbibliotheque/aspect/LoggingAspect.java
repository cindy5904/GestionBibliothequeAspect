package org.example.exogestionbibliotheque.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(* org.example.exogestionbibliotheque.service.*.*(..))")
    public void logBefore() {
        System.out.println("avant la méthode");
    }
    @After("execution(* org.example.exogestionbibliotheque.service.*.*(..))")
    public void logAfter() {
        System.out.println("après la méthode");
    }


}
