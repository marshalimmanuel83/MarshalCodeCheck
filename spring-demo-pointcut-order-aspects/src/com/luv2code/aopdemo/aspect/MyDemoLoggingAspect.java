package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.MyLuvCodePointcuts.forAllMethodsExcludeGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n Order1=======> Added @Before advice on method.");
		
		// retrieve the method signature using joinpoint
		MethodSignature theMethodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + theMethodSig);
		
		// retrieve the method parameters/arguements using joinpoint
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println("Method Arguements: " + tempArg);
		}
	}
	
}
