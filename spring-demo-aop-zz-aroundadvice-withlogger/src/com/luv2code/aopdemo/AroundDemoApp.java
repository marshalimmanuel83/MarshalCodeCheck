package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	
	public static void main(String[] args) {
		
		// read the spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortune",TrafficFortuneService.class);
		
		System.out.println("\nMain Program : AroundDemoApp");
		System.out.println("Calling the main method getFortune() from TrafficFortuneService");
		
		String data = trafficFortuneService.getFortune();
		
		System.out.println("\nYour fortune is : " + data);
		
		System.out.println("Main Program : Finished");
		
		// close the context
		context.close();

	}

}
