/**
 * 
 */
package com.dt.hippo.web.config;

import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author Siva
 * 
 */
@Configuration
@ComponentScan(basePackages = { "com.dt.hippo.web.controller",
		"com.dt.hippo.auto.web","com.dt.hippo.auto.rest" })
// ,"com.dt.hippo.auto.rest","com.dt.hippo.auto.web"
// @ComponentScan(basePackages = { "com.dt.hippo.web.test"})
// //,"com.dt.hippo.auto.rest","com.dt.hippo.auto.web"
@EnableWebMvc
// @ImportResource("classpath:dispatcher-servlet.xml")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		registry.addViewController("login").setViewName("login");
		// registry.addViewController("welcome").setViewName("welcome");
		// registry.addViewController("admin").setViewName("admin");
		// <mvc:view-controller path="/" view-name="index"/>
		// <mvc:view-controller path="/uncaughtException"/>
		// <mvc:view-controller path="/resourceNotFound"/>
		// <mvc:view-controller path="/dataAccessFailure"/>
		registry.addViewController("/").setViewName("index");
	}

	@Bean
	public InternalResourceViewResolver jspResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/jsp/");
		bean.setSuffix(".jsp");
		bean.setOrder(resolver().getOrder() + 1);
		return bean;
	}

	@Bean
	public UrlBasedViewResolver resolver() {
		// InternalResourceViewResolver url = new
		// InternalResourceViewResolver();
		// url.setPrefix("/WEB-INF/views/");
		// url.setSuffix(".jspx");
		// // url.set
		// return url;
		// <bean
		// class="org.springframework.web.servlet.view.UrlBasedViewResolver"
		// id="tilesViewResolver">
		// <property name="viewClass"
		// value="org.springframework.web.servlet.view.tiles2.TilesView" />
		// </bean>
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
		tilesViewResolver
				.setViewClass(org.springframework.web.servlet.view.tiles3.TilesView.class);
		tilesViewResolver.setOrder(10);
		return tilesViewResolver;
	}

	// @Bean
	// public ViewResolver jspResolver()
	// {
	// InternalResourceViewResolver url = new InternalResourceViewResolver();
	// url.setPrefix("/WEB-INF/views/");
	// url.setSuffix(".jspx");
	// return url;
	// }

	//
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/WEB-INF/layouts/layouts.xml",
				"/WEB-INF/views/**/views.xml");
		return tilesConfigurer;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
		// registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		// .addResourceLocations("/resources/")
		// .addResourceLocations("/css/**")
		// .addResourceLocations("/img/**")
		// .addResourceLocations("/script/**")
		// .addResourceLocations("/js/**");
		// <mvc:resources mapping="/css/**" location="/css/" />
		// <mvc:resources mapping="/img/**" location="/img/" />
		// <mvc:resources mapping="/script/**" location="/script/" />
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		converters.add(converter());
	}

	@Bean
	MappingJackson2HttpMessageConverter converter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		// converter.getObjectMapper()
		converter
				.getObjectMapper()
				.setSerializationInclusion(JsonInclude.Include.NON_NULL)
				.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
				.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false)
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);

		// .setSerializationInclusion(JsonInclude.Include.NON_NULL)
		// .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
		// .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
		// .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
		// false);
		return converter;
	}

	// @Bean(name = "messageSource")
	// public MessageSource configureMessageSource()
	// {
	// ReloadableResourceBundleMessageSource messageSource = new
	// ReloadableResourceBundleMessageSource();
	// messageSource.setBasename("classpath:messages");
	// messageSource.setCacheSeconds(5);
	// messageSource.setDefaultEncoding("UTF-8");
	// return messageSource;
	// }

	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.put("org.springframework.dao.DataAccessException", "error");
		b.setExceptionMappings(mappings);
		return b;
	}
}