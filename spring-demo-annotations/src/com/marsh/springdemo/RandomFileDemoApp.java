package com.marsh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RandomFileDemoApp {

	public static void main(String[] args) {
		// read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from the context
		SomeRandomCoach coach = context.getBean("someRandomCoach", SomeRandomCoach.class);
		
		// call method in bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		// close context
		context.close();
	}

}
