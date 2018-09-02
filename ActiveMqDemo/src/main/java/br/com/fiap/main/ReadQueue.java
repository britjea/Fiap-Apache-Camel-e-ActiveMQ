package br.com.fiap.main;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class ReadQueue {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CamelContext ctx = new DefaultCamelContext();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		
		ctx.addComponent("jms",JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		ctx.addRoutes(new RouteBuilder() {
			public void configure () {
				from("jms:Sheldon")
				.to("stream:out")
				.to("file:\\C:\\Output");
			}
		});
			
		ctx.start();
		Thread.sleep(100000);
		ctx.stop();
		}
		
}
