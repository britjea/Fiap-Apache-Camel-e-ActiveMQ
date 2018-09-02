package br.com.fiap.route;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder  extends RouteBuilder{

	@Override
		public void configure() throws Exception{
		from("file:\\C:\\InputArq").to("jms:queue:Sheldon");
		}
}

