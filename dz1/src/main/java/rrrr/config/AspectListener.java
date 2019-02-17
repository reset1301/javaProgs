package rrrr.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
//@EnableAspectJAutoProxy
@Component
public class AspectListener {
    @Around("pointcutForMethods()")
//    @Around("execution(public * *(..))")
    public Object listenForMethods(ProceedingJoinPoint point) throws Throwable {
        System.out.println("---------");
        return point.proceed();
    }

    @Pointcut("within(rrrr.*)")
    public void pointcutForMethods() {

    }

    @Around("execution(public * *(..))")
    public Object invoke(ProceedingJoinPoint methodInvocation) throws Throwable {
        System.out.println("________________");
        return methodInvocation.proceed();
    }
}
