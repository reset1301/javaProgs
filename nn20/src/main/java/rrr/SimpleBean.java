package rrr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SimpleBean {
    private static final String DEFAULT_NAME = "Luke Skywalker";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void init() {
        System.out.println("Initialize Method.");
        if (name == null) {
            System.out.println("Using default name.");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the 'age' property of any beans of type"
                    + SimpleBean.class.getSimpleName());
        }
    }

    @PostConstruct
    public void initAnnotation() {
        System.out.println("Initialize annotation.");
        if (name == null) {
            System.out.println("Using default name.");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the 'age' property of any beans of type"
                    + SimpleBean.class.getSimpleName());
        }
    }

    public void destroyMethod() {
        System.out.println("Destroy method.");
    }

    @PreDestroy
    public void destroyAnnotation() {
        System.out.println("Destroy annotation.");
    }
    @Override
    public String toString() {
        return "SimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

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
}
