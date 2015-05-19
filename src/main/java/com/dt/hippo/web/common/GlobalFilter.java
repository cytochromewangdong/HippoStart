package com.dt.hippo.web.common;

import javax.annotation.PostConstruct;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dt.hippo.business.SessionParam;

@Aspect
@Component
public class GlobalFilter
{

	@PostConstruct
	public void init()
	{
		System.out.println();
	}

	@Autowired
	SessionParam sessionParam;

	 @Pointcut("execution(* org.hibernate.SessionFactory.getCurrentSession(..))")
	 protected void hibernateSessionFetch()
	 {
	
	 }

	@AfterReturning(pointcut = "hibernateSessionFetch()", returning = "result")
	public void enableGlobalFilter(JoinPoint joinPoint,
			Object result)
	{

		Session session = (Session) result;

		session.enableFilter("GLOBAL_FILTER").setParameter(
				"status", 0);

	}
	// @AfterReturning(pointcut="execution(* test123(..))",
	// returning="returnString")

	// @AfterReturning(pointcut =
	// "execution(* com.dt.hippo.web.controller.api.BusinessController.*(..)")
	// public void getNameReturningAdvice(Object returnString)
	// {
	// System.out
	// .println("getNameReturningAdvice executed. Returned String="
	// + returnString);
	// }
	
	@Pointcut("execution(* test123(..))")
	// returning="returnString")
//	@Pointcut("execution(* com.dt.hippo.web.controller.api.BusinessController.*(..))")
	public void thing()
	{
	}

	@Before("thing()")
	public void doStuffBeforeThing(JoinPoint joinPoint)
	{
		// do stuff here
		System.out
				.println("getNameReturningAdvice executed. Returned String="
						+ joinPoint.toString());
	}

}