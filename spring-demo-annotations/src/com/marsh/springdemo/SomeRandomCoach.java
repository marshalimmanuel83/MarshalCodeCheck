package com.marsh.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SomeRandomCoach implements Coach {
	
	@Autowired
	@Qualifier("readFileFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Do some random workout. You'll be fine.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
