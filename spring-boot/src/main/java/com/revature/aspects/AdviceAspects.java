package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AdviceAspects {

	@Before("noReturn()")
	public void sayHello(JoinPoint jp) {
		System.out.println(jp.getSignature());
		System.out.println("hello");
	}

	@After("noReturn()")
	public void sayGoodbye() {
		System.out.println("good bye");
	}
	
	@AfterReturning(pointcut="noReturn()", returning="obj")
	public void returnedObject(String obj) {
		System.out.println("After returning advice, method returned " + obj);
	}
	
	@AfterThrowing(pointcut="noReturn()", throwing="err")
	public void thrownException(Throwable err) {
		System.out.println("Method threw exception with message " + err.getMessage());
	}

	@Pointcut("execution(String com.revature..*(..))")
	public void noReturn() {
	}
}
