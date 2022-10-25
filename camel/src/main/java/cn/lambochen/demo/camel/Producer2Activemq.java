package cn.lambochen.demo.camel;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author lambochen
 * @date 2022-10-25 19:01
 */
public class Producer2Activemq {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                "admin", "admin", "http://127.0.0.1:8888"
        );
        context.addComponent("activemq", (Component) JmsComponent.jmsComponentAutoAcknowledge(factory));
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start").to("activemq:queue:myqueue");
            }
        });

        context.start();
        ProducerTemplate template = context.createProducerTemplate();
        template.sendBody("direct:start", "测试消息");
    }
}
