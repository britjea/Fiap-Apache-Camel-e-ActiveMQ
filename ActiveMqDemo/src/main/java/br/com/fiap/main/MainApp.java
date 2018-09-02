package br.com.fiap.main;

import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import br.com.fiap.route.SimpleRouteBuilder;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
		CamelContext ctx = new DefaultCamelContext();
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		
		ctx.addComponent("jms",JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		try {
			ctx.addRoutes(routeBuilder);
			ctx.start();
			Thread.sleep(5*60*100);
			ctx.stop();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
