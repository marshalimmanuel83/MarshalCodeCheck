package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyLoggingToCloudAspect {

	@Before("com.luv2code.aopdemo.aspect.MyLuvCodePointcuts.forAllMethodsExcludeGetterSetter()")
	public void beforeLogToCloud() {
		System.out.println("\n Order3=======> Logging to Cloud in Asyncronous fashion.");
	}
	
}
