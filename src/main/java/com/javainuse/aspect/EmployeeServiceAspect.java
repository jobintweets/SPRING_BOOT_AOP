package com.javainuse.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

	@Before(value = "execution(* com.javainuse.service.EmployeeService.*(..)) and args(name,empId)")
	public void beforeAdvice(JoinPoint joinPoint, String name, String empId) {
		System.out.println("Before method:" + joinPoint.getSignature());

		System.out.println("Creating Employee with name - " + name + " and id - " + empId);
	}

	//advice
	@After(value = "execution(* com.javainuse.service.EmployeeService.*(..)) and args(name,empId)")
	public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
		System.out.println("After method:" + joinPoint.getSignature());

		System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
	}

  @AfterReturning(value = "execution(* com.javainuse.service.EmployeeService.*(..)) and args(text)")
  public void afterAdvice(JoinPoint joinPoint, String text) {
    System.out.println("After method:" + joinPoint.getSignature());

    System.out.println("Successfully logged " + text);
  }

}
