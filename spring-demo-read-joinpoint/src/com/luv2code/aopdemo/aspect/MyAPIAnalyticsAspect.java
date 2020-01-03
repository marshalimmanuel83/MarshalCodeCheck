package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyAPIAnalyticsAspect {

	@Before("com.luv2code.aopdemo.aspect.MyLuvCodePointcuts.forAllMethodsExcludeGetterSetter()")
	public void beforeAPIAnalytics() {
		System.out.println("\n Order2=======> API Analytics on method.");
	}
	
}
