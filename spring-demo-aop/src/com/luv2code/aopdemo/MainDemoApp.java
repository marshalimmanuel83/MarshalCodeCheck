package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read the spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring container
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		
		// call the business method
		accountDAO.addAccount();
		
		// get the bean for MembershipDAO from spring container
		MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
		membershipDAO.addAccount();
		
		// close the context
		context.close();

	}

}
