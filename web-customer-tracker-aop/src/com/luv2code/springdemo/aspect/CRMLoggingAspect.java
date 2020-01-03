package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger support
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// add pointcut declarations for controller
	@Pointcut("execution (* com.luv2code.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	// add pointcut declarations for service and dao
	@Pointcut("execution (* com.luv2code.springdemo.service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution (* com.luv2code.springdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// add pointcut for all the packages
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAllPackages() {}
	
	// add @Before advice
	@Before("forAllPackages()")
	public void beforeAdviceMethod(JoinPoint theJoinPoint) {
		
		String methodName = theJoinPoint.getSignature().toShortString();
		logger.info("=======> @Before : Method Signature is " + methodName);
		
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut = "forAllPackages()",
			returning = "theResult")
	public void afterReturningAdviceMethod(JoinPoint theJoinPoint, Object theResult) {
		
		// display the method name fetched from the JoinPoint
		String methodName = theJoinPoint.getSignature().toShortString();
		logger.info("=======> @AfterReturning : Method Signature is " + methodName);
		
		// display the data returned as result
		logger.info("The result returned is " + theResult);
		
	}
}
