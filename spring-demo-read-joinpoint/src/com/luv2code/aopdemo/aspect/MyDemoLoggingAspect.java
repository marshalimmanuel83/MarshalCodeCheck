package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.dao.AccountDAO;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.MyLuvCodePointcuts.forDAOPackage()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n Order1=======> Added @Before advice on method.");
		
		// retrieve the method signature using joinpoint
		MethodSignature theMethodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + theMethodSig);
		
		// retrieve the method parameters/arguments using joinpoint
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println("Method Arguments: " + tempArg);
			
			if (tempArg instanceof AccountDAO) {
				
				// downcast and print account specific stuff
				AccountDAO theAccountDAO = (AccountDAO) tempArg;
				
				System.out.println("Account Name: " + theAccountDAO.getName());
				System.out.println("Service Code: " + theAccountDAO.getServiceCode());
			}
		}
	}
	
}
