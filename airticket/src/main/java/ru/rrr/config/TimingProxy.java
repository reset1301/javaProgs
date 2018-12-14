package ru.rrr.config;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

@Slf4j
public class TimingProxy implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object retVal = methodInvocation.proceed();
        stopWatch.stop();
        log.info("Method " + methodInvocation.getMethod().getName() + "() took: " + stopWatch.getTotalTimeMillis() + " millis.");

        return retVal;
    }
}
