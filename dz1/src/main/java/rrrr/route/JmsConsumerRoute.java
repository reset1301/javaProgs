package rrrr.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import rrrr.MyProcessor;

@Component
public class JmsConsumerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:queue:test.queue")
                .process(new MyProcessor())
                .to("stream:out");
    }
}
