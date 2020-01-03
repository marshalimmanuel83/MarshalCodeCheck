package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// define @Around advice
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundAdviceMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print the method you're advising on
		myLogger.info("Executing @Around advice. Method Name: " + proceedingJoinPoint.getSignature().toShortString());
		
		// get begin time stamp
		long beginTime = System.currentTimeMillis();
		
		// now, let's execute the method
		Object result = proceedingJoinPoint.proceed();
		
		// get end time stamp
		long endTime = System.currentTimeMillis();
		
		// find the difference and display it
		long timeDiff = endTime - beginTime;
		
		myLogger.info("\nTotal time taken : " + timeDiff/1000.0 + " seconds.");
		
		return result;
	}
	
	// define @After (finally) advice
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.getDataAndModify(..))")
	public void afterFinallyAdviceMethod(JoinPoint theJoinPoint) {
		myLogger.info("Order 1 > Executing After Advice");
		// print the method name
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("From @After Advice: After method signature ======> " + method);
	}
	
	// define @AfterThrowing advice
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.getDataAndModify(..))",
			throwing = "theExc"
			)
	public void afterThrowingAdviceMethod(JoinPoint theJoinPoint, Throwable theExc) {
		myLogger.info("Order 1 > Executing AfterThrowing Advice");
		// print the method name
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("From @AfterThrowing Advice: After throwing method signature ======> " + method);
		
		// print the log about exception caught
		myLogger.info("From @AfterThrowing Advice: The exception is " + theExc);
	}
	
	// Note: the returning value and the method parameter that defines the return value should be same. 
	// Eg., result. The value name can be anything, but it should be same in both the places.
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAllAccounts(..))",
			returning = "result"
			)
	public void afterReturningAdviceMethod(JoinPoint theJoinPoint, List<Account> result) {
		myLogger.info("Order 1 > Executing AfterReturning Advice");
		// print the method name
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("method signature ======> " + method);
		
		myLogger.info("result ======> " + result);
		
	}
	
	// defining AfterReturning advice and make changes in the return object
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.getDataAndModify(..))",
			returning = "result"
			)
	public void afterReturningAdviceGetAndModifyResult(JoinPoint theJoinPoint, List<Account> result) {
		myLogger.info("Order 1 > Executing AfterReturning Advice along with modify return value");
		
		// print the method name
		String methodName = theJoinPoint.getSignature().toShortString();
		myLogger.info("Method Signature : " + methodName);
		
		if (!result.isEmpty()) {
			Account theAccount = result.get(2);
			myLogger.info("Result ============> " + result);
			
			theAccount.setName("Brandon");
			theAccount.setLevel("Silver");
			
			myLogger.info("Result after modifying the returned value ============> " + result);
		}
	}
	
}
