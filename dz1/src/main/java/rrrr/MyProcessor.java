package rrrr;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
public class MyProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String inBody = exchange.getIn().getBody(String.class);
        log.info("Received in message with body {}", inBody);
        log.info("Prefixing body ...");
        inBody = "Prefixed " + inBody + " Postfixed";
        exchange.getIn().setBody(inBody);
    }
}
