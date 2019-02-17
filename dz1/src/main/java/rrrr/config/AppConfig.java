package rrrr.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "rrrr")
public class AppConfig {
    //    private final ApplicationContext applicationContext;
    @Autowired
    private AspectListener listener;

    @Value("${brokerURL}")
    private String brokerURL;

    @Bean("aspectListener")
    AspectListener getAspectListener() {
        return new AspectListener();
    }

//    @Bean(name = "activeMQConnectionFactory")
//    @Scope(value = "singleton")
//    public ActiveMQConnectionFactory getActiveMQConnectionFactory() {
//        return new ActiveMQConnectionFactory();
//    }

//    @Bean(name = "activemq")
//    @Scope(value = "singleton")
//    public ActiveMQComponent getActiveMQComponent() {
//        ActiveMQComponent activeMQComponent = new ActiveMQComponent();
//        activeMQComponent.setBrokerURL("tcp://127.0.0.1:61616");
//        return activeMQComponent;
//    }

}
