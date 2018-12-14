package rrr;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentAndPropertySource {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.refresh();

        ConfigurableEnvironment environment = ctx.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();

        Map<String, Object> appMap = new HashMap<>();
        appMap.put("user.home", "c:/");
        appMap.put("JAVA_HOME", "c:/111");
        propertySources.addLast(new MapPropertySource("PROP_MAP", appMap));
//        propertySources.addFirst(new MapPropertySource("PROP_MAP", appMap));

        System.out.println("System user.home: " + System.getProperty("user.home"));
        System.out.println("Map user.home: " + environment.getProperty("user.home"));
        System.out.println("System JAVA_HOME: " + System.getProperty("JAVA_HOME"));
        System.out.println("Map JAVA_HOME: " + environment.getProperty("JAVA_HOME"));
    }
}
