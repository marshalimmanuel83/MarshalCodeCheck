package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	// Note: the returning value and the method parameter that defines the return value should be same. 
	// Eg. result. The value name can be anything, but it should be same in both the places.
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAllAccounts(..))",
			returning = "result"
			)
	public void afterReturningAdviceMethod(JoinPoint theJoinPoint, List<Account> result) {
		System.out.println("Order 1 > Executing AfterReturning Advice");
		// print the method name
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("method signature ======> " + method);
		
		System.out.println("result ======> " + result);
		
	}
	
	// defining AfterReturning advice and make changes in the return object
	@AfterReturning(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.getDataAndModify(..))",
			returning = "result"
			)
	public void afterReturningAdviceGetAndModifyResult(JoinPoint theJoinPoint, List<Account> result) {
		System.out.println("Order 1 > Executing AfterReturning Advice along with modify return value");
		
		// print the method name
		String methodName = theJoinPoint.getSignature().toShortString();
		System.out.println("Method Signature : " + methodName);
		
		if (!result.isEmpty()) {
			Account theAccount = result.get(2);
			System.out.println("Result ============> " + result);
			
			theAccount.setName("Brandon");
			theAccount.setLevel("Silver");
			
			System.out.println("Result after modifying the returned value ============> " + result);
		}
	}
	
}
