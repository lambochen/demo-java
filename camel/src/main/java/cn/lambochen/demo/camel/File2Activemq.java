package cn.lambochen.demo.camel;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author lambochen
 * @date 2022-10-25 17:54
 */
public class File2Activemq {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();

        ActiveMQConnectionFactory mqConnectionFactory = new ActiveMQConnectionFactory(
                "admin", "admin", "http://127.0.0.1:8161"
        );
        camelContext.addComponent("activemq", (Component) JmsComponent.jmsComponentAutoAcknowledge(mqConnectionFactory));

        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:input_box")
                        .to("activemq:queue:myqueue");
            }
        });

        camelContext.start();
    }

}
