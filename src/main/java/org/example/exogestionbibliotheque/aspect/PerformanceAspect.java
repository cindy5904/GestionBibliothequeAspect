package org.example.exogestionbibliotheque.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {


    @Pointcut("@annotation(org.example.exogestionbibliotheque.annotation.AnnotationPerformance)")
    public void performancePointCut() {

    }
    @Around("performancePointCut()")
    public Object performanceAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Temps d'execution : "+(endTime - startTime) + " ms");
        return result;
    }

}
