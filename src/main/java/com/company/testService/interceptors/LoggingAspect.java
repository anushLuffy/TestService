package com.company.testService.interceptors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	 private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
     
	 @Before(value = "execution(* com.company.testService.service.OrderService.*(..)) and args(userId)")
		public void beforeAdvice(JoinPoint joinPoint, int userId) {
			System.out.println("Before method:" + joinPoint.getSignature());

			System.out.println("getting orders with user id  - " + userId );
		}

		@After(value = "execution(* com.company.testService.service.OrderService.*(..)) and args(userId)")
		public void afterAdvice(JoinPoint joinPoint, int userId) {
			System.out.println("After method:" + joinPoint.getSignature());

			System.out.println("Successfully getting orders with user id  - " + userId );
		}
}
