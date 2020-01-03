package com.marsh.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] randomFortune = { "Today is your great day!", 
			"Today is not that good for you.",
			"Today is a worst day for you." };
	
	// create a random number generator
	private Random random = new Random();

	@Override
	public String getFortune() {
		return randomFortune[random.nextInt(randomFortune.length)];
	}

}
