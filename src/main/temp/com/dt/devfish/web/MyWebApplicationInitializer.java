package com.dt.hippo.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public interface MyWebApplicationInitializer {
	void onStartup(ServletContext servletContext) throws ServletException;

}
