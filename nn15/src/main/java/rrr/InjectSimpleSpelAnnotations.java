package rrr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
