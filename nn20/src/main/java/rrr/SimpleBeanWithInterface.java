package rrr;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SimpleBeanWithInterface implements InitializingBean, DisposableBean, BeanNameAware {
    private static final String DEFAULT_NAME = "Luke Skywalker";
    private String name;
    private int age = Integer.MIN_VALUE;
    private String beanName;

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

    //    DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy interface.");
    }

    @PreDestroy
    public void destroyAnnotation() {
        System.out.println("Destroy annotation.");
    }

    //    InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
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


    //BeanNameAware
    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getName() {
        return name;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "SimpleBeanWithInterface{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
