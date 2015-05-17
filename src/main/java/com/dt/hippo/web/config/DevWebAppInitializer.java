package com.dt.hippo.web.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.dt.hippo.config.ApplicationContext;

public class DevWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB

	// @Override
	public void XXX(ServletContext servletContext) throws ServletException {
		// XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		// appContext.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ApplicationContext.class);
		// servletContext.addListener(new ContextLoaderListener(appContext));
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				"appServlet", new DispatcherServlet(appContext));

		MultipartConfigElement element = new MultipartConfigElement(null,
				5000000, 5000000, 0);
		dispatcher.setMultipartConfig(element);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		// servletContext.addListener(new ContextLoaderListener(appTContext));

	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ApplicationContext.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class<?>[] { WebMvcConfig.class };
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

//	@Override
//	protected Filter[] getServletFilters() {
//		return new Filter[] { new HiddenHttpMethodFilter(),
//				new MultipartFilter(), new OpenEntityManagerInViewFilter() };
//	}

	@Override
    protected Filter[] getServletFilters() {
       return new Filter[]{ 
    		   new DelegatingFilterProxy("springSecurityFilterChain"),
    		   //new OpenEntityManagerInViewFilter()
    		   };
    } 
//	@Override
//	protected void registerDispatcherServlet(ServletContext servletContext) {
//		super.registerDispatcherServlet(servletContext);
//
//		servletContext.addListener(new HttpSessionEventPublisher());
//
//	}

	@Override
	protected void customizeRegistration(
			ServletRegistration.Dynamic registration) {

		// File uploadDirectory =
		// ServiceConfiguration.CRM_STORAGE_UPLOADS_DIRECTORY;
		// uploadDirectory.getAbsolutePath()
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
				null, maxUploadSizeInMb, maxUploadSizeInMb * 2,
				maxUploadSizeInMb / 2);

		registration.setMultipartConfig(multipartConfigElement);

	}

}
