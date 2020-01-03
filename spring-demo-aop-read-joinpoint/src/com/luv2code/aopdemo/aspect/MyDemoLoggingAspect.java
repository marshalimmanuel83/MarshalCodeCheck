package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.MyLuvCodePointcuts.forAllMethodsExcludeGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n Order1=======> Added @Before advice on method.");
	}
	
}
