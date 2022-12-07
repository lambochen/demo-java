package cn.lambochen.demo.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.List;

/**
 * @author lambochen
 * @date 2022-10-25 19:09
 */
public class PubSub {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                        .process(new Processor() {
                            @Override
                            public void process(Exchange exchange) throws Exception {
                                System.out.println("消息处理...start");

                                String message = exchange.getIn().getBody(String.class);

                                message = message + "-process";

                                // repub
                                exchange.getOut().setBody(message);
                            }
                        })
                        .to("seda:end");
            }
        });
        context.start();

        List<Route> routes = context.getRoutes();

        // produce
        ProducerTemplate producerTemplate = context.createProducerTemplate();
        producerTemplate.sendBody("direct:start", "originalMsg");

        // consume
        ConsumerTemplate consumerTemplate = context.createConsumerTemplate();
        String message = consumerTemplate.receiveBody("seda:end", String.class);

        System.out.println("consume msg body: " + message);
    }
}
