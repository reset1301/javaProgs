package rrr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource(value = "context.xml")
@PropertySource(value = "classpath:message.properties")
@ComponentScan(basePackages = "rrr")
@EnableTransactionManagement
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    @Lazy(value = true)
    public MessageProvider messageProvider() {
        ConfigurableMessageProvider provider = new ConfigurableMessageProvider();
        provider.setMessage(env.getProperty("message"));
        return provider;
//        return new ConfigurableMessageProvider();
    }

    @Bean
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());

        return renderer;
    }
}
