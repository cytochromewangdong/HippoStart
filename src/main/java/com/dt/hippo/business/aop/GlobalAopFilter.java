package com.dt.hippo.business.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dt.hippo.business.SessionParam;
import com.dt.hippo.business.base.BaseService;
import com.dt.hippo.core.base.BaseBeanCommon;
import com.dt.hippo.core.security.SecurityUser;

@Aspect
@Component
public class GlobalAopFilter extends BaseService
{

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

	// @Pointcut("execution(* test123(..))")
	// returning="returnString")
	// @Pointcut("execution(* com.dt.hippo.web.controller.api.BusinessController.*(..))")
	@Pointcut("execution(* com.dt.hippo..*Repository.save(..))")
	public void beforeUpdateOrSave()
	{
	}

	@Before("beforeUpdateOrSave()")
	public void doStuffBeforeSaveOrUpdate(JoinPoint joinPoint)
	{
		Object[] args = joinPoint.getArgs();
		for (Object arg : args)
		{
			if (arg instanceof BaseBeanCommon)
			{
				prepare((BaseBeanCommon) arg);
			}
		}

	}


}