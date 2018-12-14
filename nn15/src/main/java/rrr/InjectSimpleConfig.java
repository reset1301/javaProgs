package rrr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {
    @Value("Roman")
    private String name;// = "Roman";
    @Value("35")
    private int age;// = 35;
    @Value("74")
    private float height;// = 74;
    @Value("true")
    private boolean programmer;// = true;
    @Value("1131877821498")
    private Long ageInMSeconds;// = 1131877821498L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public Long getAgeInMSeconds() {
        return ageInMSeconds;
    }

    public void setAgeInMSeconds(Long ageInMSeconds) {
        this.ageInMSeconds = ageInMSeconds;
    }
}
