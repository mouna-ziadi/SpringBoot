package tn.esprit.spring.stationdeski.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.esprit.spring.stationdeski.Services.SkieurService.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @After("execution(* tn.esprit.spring.stationdeski.Services.AbonnementService.*(..))")
    public void logMethodEntryA(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @AfterReturning("execution(* tn.esprit.spring.stationdeski.Services.MoniteurService.*(..))")
    public void logMethodEntryR(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @AfterThrowing("execution(* tn.esprit.spring.stationdeski.Services.InscriptionService.*(..))")
    public void logMethodEntryT(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    /*
    @Around("execution(* tn.esprit.spring.stationdeski.Services.PisteService.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }
    */
}
