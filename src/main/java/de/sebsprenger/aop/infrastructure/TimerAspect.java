package de.sebsprenger.aop.infrastructure;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimerAspect {

    private final MetricPublisher metrics;

    public TimerAspect(MetricPublisher metrics) {
        this.metrics = metrics;
    }

    @Around("execution(public * do*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[around ] >> stuff before " + joinPoint.getSignature());
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        metrics.push("timing", executionTime);
        System.out.println("[around ] >> stuff after");

        return result;
    }

    @Before("@annotation(Timed)")
    public void before(JoinPoint joinPoint) throws Throwable {
        System.out.println("[before ] >> " + joinPoint.getSignature() + " is about to execute");
    }

    @After("@annotation(Timed)")
    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("[after  ] >> " + joinPoint.getSignature() + " just finished whatever it did");
    }

    @AfterReturning(value = "@annotation(Timed)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) throws Throwable {
        System.out.println("[after r] >> " + joinPoint.getSignature() + " returned " + result);
    }

    @AfterThrowing(value = "@annotation(Timed)", throwing = "exception")
    public void afterThrowing(Exception exception) throws Throwable {
        System.out.println("[after t] >> threw " + exception);
    }

}
