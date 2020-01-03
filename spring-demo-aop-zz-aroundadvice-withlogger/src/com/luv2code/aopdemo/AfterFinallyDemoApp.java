package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		// read the spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring container
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		
		// calling method where the AfterReturning advice is defined
		//List<Account> allAccounts = accountDAO.findAllAccounts();
		
		// calling method where the AfterReturning advice gets and then modifies the result
		List<Account> getAccounts = null;
		try {
			// add a boolean to simulate exception scenario for using @AfterThrowing advice
			boolean tripWire = false;
			getAccounts = accountDAO.getDataAndModify(tripWire);
		} catch (Exception e) {
			System.out.println("Main Method: Exception occured. Cause: " + e);
		}
		
		/*System.out.println("\n\n Main Program: AfterReturningDemoApp");
		
		System.out.println("-------");
		
		System.out.println("Accounts: " + allAccounts);
		
		System.out.println("\n");*/
		
		// close the context
		context.close();

	}

}
