package com.revature.aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	@Around("everything()")
	public Object logger(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		Signature sig = pjp.getSignature();
		System.out.println("Method with signature " + sig + " called.");
		System.out.println("With arguments: " + Arrays.toString(pjp.getArgs()));

		try {
			obj = pjp.proceed(); // let the method that this wraps around now execute and get its return
		} catch (Throwable e) {
			System.out.println(sig + " threw " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		System.out.println(sig + " returned: " + obj);

		return obj;
	}

	@Pointcut("execution(* com.revature..*(..))")
	public void everything() {
	}

}
