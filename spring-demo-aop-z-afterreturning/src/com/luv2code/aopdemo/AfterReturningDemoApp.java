package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read the spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring container
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		
		// calling method where the AfterReturning advice is defined
		//List<Account> allAccounts = accountDAO.findAllAccounts();
		
		// calling method where the AfterReturning advice gets and then modifies the result
		List<Account> getAccounts = accountDAO.getDataAndModify();
		
		/*System.out.println("\n\n Main Program: AfterReturningDemoApp");
		
		System.out.println("-------");
		
		System.out.println("Accounts: " + allAccounts);
		
		System.out.println("\n");*/
		
		// close the context
		context.close();

	}

}
