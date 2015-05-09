package com.dt.hippo.web;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyServletContainerInitializer2 implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx)
			throws ServletException {
		System.out.println("===========33333333333333");
		
	}

}
