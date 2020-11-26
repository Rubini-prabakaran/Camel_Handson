package com.cts.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.builder.RouteBuilder;

public class CamelTimer {
	public static void main(String[] args) throws Exception{
	CamelContext camel=new DefaultCamelContext();
	camel.addRoutes(new RouteBuilder() {
		
		@Override
		public void configure() throws Exception{
			from("timer:myTimer?period=1000")
			.setBody(simple("Hello from camel at ${header.firedTime}"))
			.to("stream:out");
			
		}
		
	});
	camel.start();	
	Thread.sleep(5000);
	camel.stop();
	
	}
	}
