package com.marsh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		// get the same bean with different variable name
		TennisCoach alphaCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		
		boolean isSameObject = (theCoach == alphaCoach);
		
		System.out.println("\n Pointing to same object? " + isSameObject);
		
		System.out.println("\n Path of object theCoach is: " + theCoach);
		
		System.out.println("\n Path of object alphaCoach is: " + alphaCoach);
		
		/* Testing the scope's behavior*/
		theCoach.setFirstName("Nancy");
		theCoach.setLastName("Marshal");
		
		alphaCoach.setFirstName("Marshal");
		alphaCoach.setLastName("Immanuel");
		
		System.out.println("theCoach>> FirstName: "+ theCoach.getFirstName() + " | LastName: " + theCoach.getLastName());
		System.out.println("alphaCoach>> FirstName: "+ alphaCoach.getFirstName() + " | LastName: " + alphaCoach.getLastName());
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close context
		context.close();
	}

}