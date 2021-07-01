package com.lakkam.springmvcdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

	/*
	 * This is Pointcut declaration separately
	 */
	@Pointcut("execution(public String calculatePremium())")
	// This is Pointcut name
	public void myPremiumCalPointcut() {
	}

	@Pointcut("execution(public String processClaim())")
	public void myClaimPointcut() {
	}

	// Using above declared pointcut here inside @Before aspect
	@Before("myPremiumCalPointcut()")
	public void peformBeforePremiumCalculation() {
		System.out.println("This logging Aspect is to perform before Premium Calculation Service : ");
	}

	@Before("myClaimPointcut()")
	public void performBeforeAutoClaim() {
		System.out.println(this.getClass().getSimpleName()
				+ " : Performing background verification before processing Auto Claim : ");
	}

	// Lets create and combine point cuts
	// Lets try out ordering of pointcuts
	// Lets try JoinPoint for reading method signatures and mathod parameters values
	// that we are joining
	// Lets try @AfterReturning advice for successful method execution and during
	// return and try return type access
	// Lets try @AfterThrowing advice for exception flow
	// Lets try @After advice for successful and exception flow. Its like finally
	// block
	// Lets try @Around advice. This will work before and after method execution and
	// can handle exception flow as well with this advice like handle exception and
	// rethrow the exception.

	/*
	 * This aspect is for doing something after successful execution of
	 * myPremiumCalPointcut pointcut which interns configured to execute for
	 * calculatePremium() method
	 * JoinPoint is a special API to read method data like params, return value, etc.
	 */
	@AfterReturning(pointcut = "myPremiumCalPointcut()", returning = ("premiumVal"))
	public void performAfterReturningCalPremium(JoinPoint jp, String premiumVal) {
		Object[] methodParams = jp.getArgs();
		for (Object param : methodParams) {
			System.out.println("Getting method Params : " + param);
		}
		System.out.println("Getting premium value in my Aspect : " + premiumVal);
	}

	@AfterThrowing(pointcut = "myClaimPointcut()", throwing = "exception")
	public void performAfterThrowingInClaim(JoinPoint jp, Throwable exception) {
		System.out.println("AfterThrowing aspect catching the exception in claim processing : " + exception);
	}

	@Around("myPremiumCalPointcut()")
	public Object performAroundReturningCalPremium(ProceedingJoinPoint pjp) throws Throwable {
		// When we use @QAround advice control flow will stop here if we dont use
		// proceed method from ProceedingJoinPoint
		// And we must return the result as well to enable method ducking
		System.out.println("Executing @Around advice for premium cal method : >>>");
		return pjp.proceed();

	}

}
