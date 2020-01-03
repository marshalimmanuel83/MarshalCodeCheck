package com.marsh.springdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class ReadFileFortuneService implements FortuneService {
	
	private String fileName = "fortunefile.txt";
	private String[] fortuneFromFile;
	private Random random = new Random();

	@Override
	public String getFortune() {
		// get the fortune from the string array randomly and return the result
		return fortuneFromFile[random.nextInt(fortuneFromFile.length)];
	}

	
	/**
	 * This method reads fortunes from a file and store them in an array of string
	 * @return string array of fortunes
	 */
	@PostConstruct
	private void getFortunesFromFile() {
		System.out.println(">> ReadFileFortuneService: inside getFortunesFromFile() method, which is an init method that uses @PostConstruct annotation.");
		List<String> list = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			list = stream.collect(Collectors.toList());
			fortuneFromFile = list.toArray(new String[list.size()]);

		} catch (IOException e) {
			e.printStackTrace();
		} catch(SecurityException se) {
			se.printStackTrace();
		} catch(Exception exp) {
			exp.printStackTrace();
		} finally {
			if (list != null) {
				list = null;
			}
		}
	}
}