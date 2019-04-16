package itlab.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AroundAopAspect {

    @Around("@annotation(itlab.annotation.AopTrack)")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        }
        catch(Throwable ex) {
            return "N/A";
        }
    }
}
