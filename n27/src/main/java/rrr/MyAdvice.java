package rrr;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("advice")
public class MyAdvice implements MethodBeforeAdvice {
    @Autowired
    private String string;

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Executing: " + method);
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
