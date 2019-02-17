package rrrr.route;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import rrrr.MyProcessor;

@Slf4j
//@EnableAspectJAutoProxy
@Component
public class MyRouteBuilder extends RouteBuilder {
    public void configure() throws InterruptedException {
        from("timer:fire?period=500")
//                .onException(Exception.class).handled(true).process(exchange -> exchange.getException().printStackTrace())
                .setBody(constant("Hello Chapter3"))
//                .pipeline("stream:out","activemq:queue:test.queue")
                .process(new MyProcessor())
                .to("stream:out")
                .process(new Processor() {
                    public void process(Exchange exchange)
                            throws Exception {
                        String body =
                                exchange.getIn().getBody(String.class);
                        if (body.startsWith("Prefixed ")) {
                            body = body.substring
                                    ("Prefixed ".length());
                            exchange.getIn().setBody(body);
                        }
                    }

                })
                .to("activemq:topic:test.queue");


//        2 consumer'a on 1 queue. Оба получают и обрабатывают сообщения.
//        Для того, чтобы получал только один consumer, необходимо
//        activemq:topic:test.queue заменить на activemq:queue:test.queue

        from("activemq:topic:test.queue")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        exchange.getIn().setBody("From 1: " + exchange.getIn().getBody());
                    }
                })
                .to("stream:out");

        from("activemq:topic:test.queue")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String body = (String) exchange.getIn().getBody();
                        exchange.getIn().setBody("From 2: " + body + body);
                    }
                })
                .to("stream:out");

    }

}


