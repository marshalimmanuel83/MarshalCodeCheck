package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forAnyAdvice() {}
	
	@Before("forAnyAdvice()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=======> Added @Before advice on method.");
		
	}
	
	@Before("forAnyAdvice()")
	public void beforeAPIAnalytics() {
		System.out.println("\n=======> API Analytics on method.");
	}
	
}
