/**
 * 
 */
package com.marsh.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author marshal_sudhan
 *
 */
@Component
@Scope("prototype")
public class TennisCoach implements Coach {
	
	private String firstName;
	private String lastName;

	public TennisCoach() {
		System.out.println(">>TennisCoach: inside the defauld 'no-org' constructor.");
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside doMyStartupStuff()");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside doMyCleanupStuff()");
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/* This approach is called Field Injection; defining Bean with @Autowired annotation */
	//@Autowired
	//@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	/*
	 * Note, I have renamed this method from setFortuneService() to
	 * doSomeCrazyStuff(), because, as I have used @Autowired on this method, I can
	 * be free to give this method any name I want.
	 */
	/*@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println(">>TennisCouch: inside doSomeCrazyStuff() method.");
		this.fortuneService = fortuneService;
	}*/

	// You have to place the @Qualifier annotation inside of the constructor arguments.
	@Autowired 
	public TennisCoach(@Qualifier("randomFortuneService")FortuneService theFortuneService) {
		fortuneService = theFortuneService; 
	}
	 

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
