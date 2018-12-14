package rrr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;
import sun.net.www.content.text.Generic;

@Service("injectSimpleSpelAnnotations")
public class InjectSimpleSpelAnnotations {
    @Value("#{injectSimpleConfig.name}")
    private String name;
    @Value("#{injectSimpleConfig.age}")
    private int age;
    @Value("#{injectSimpleConfig.height}")
    private float height;
    @Value("#{injectSimpleConfig.programmer}")
    private boolean programmer;
    @Value("#{injectSimpleConfig.ageInMSeconds}")
    private Long ageInMSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("context.xml");
        ctx.refresh();
        InjectSimpleSpelAnnotations issa = (InjectSimpleSpelAnnotations) ctx.getBean("injectSimpleSpelAnnotations");
        System.out.println(issa);
    }
    @Override
    public String toString() {
        return "InjectSimpleSpelAnnotations{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", programmer=" + programmer +
                ", ageInMSeconds=" + ageInMSeconds +
                '}';
    }
}
