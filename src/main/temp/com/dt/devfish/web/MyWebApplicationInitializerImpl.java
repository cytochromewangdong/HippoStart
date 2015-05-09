package com.dt.hippo.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyWebApplicationInitializerImpl implements MyWebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		System.out.println("dododododdo ");
		
	}

}
