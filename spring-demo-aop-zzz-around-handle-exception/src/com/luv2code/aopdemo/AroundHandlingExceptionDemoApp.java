package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandlingExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandlingExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		// read the spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortune",TrafficFortuneService.class);
		
		myLogger.info("\nMain Program : AroundDemoApp");
		myLogger.info("Calling the main method getFortune() from TrafficFortuneService");
		
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		
		myLogger.info("\nYour fortune is : " + data);
		
		myLogger.info("Main Program : Finished");
		
		// close the context
		context.close();

	}

}
