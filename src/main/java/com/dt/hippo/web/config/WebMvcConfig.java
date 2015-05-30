/**
 * 
 */
package com.dt.hippo.web.config;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
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
import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * @author Siva
 * 
 */
@Configuration
@ComponentScan(basePackages = { "com.dt.hippo.web.controller",
		"com.dt.hippo.auto.web", "com.dt.hippo.auto.rest","com.dt.hippo.web.common" })
// ,"com.dt.hippo.auto.rest","com.dt.hippo.auto.web"
// @ComponentScan(basePackages = { "com.dt.hippo.web.test"})
// //,"com.dt.hippo.auto.rest","com.dt.hippo.auto.web"
@EnableSwagger
@EnableWebMvc
@EnableAspectJAutoProxy
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

	// <beans:bean id="documentationController"
	// class="com.knappsack.swagger4springweb.controller.ApiDocumentationController"
	// p:basePath="http://localhost:8080/yourapp"
	// p:baseControllerPackage="com.knappsack.swagger4springweb.controllers.api"
	// p:baseModelPackage="com.knappsack.swagger4springweb.models"
	// p:apiVersion="v1" />
	// @Bean
	// public ApiDocumentationController documentationController()
	// {
	// ApiDocumentationController documentationController = new
	// ApiDocumentationController();
	// documentationController.setBaseControllerPackage("com.dt.hippo.auto.rest");
	// documentationController.setApiVersion("v1");
	// return documentationController;
	// }
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
		registry.addResourceHandler("/resources/**", "*.html")
				.addResourceLocations("/resources/", "/");
		// <mvc:resources mapping="*.html" location="/" />
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
		// converter.setObjectMapper(new
		// com.knappsack.swagger4springweb.util.ScalaObjectMapper());
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

	private SpringSwaggerConfig springSwaggerConfig;

	// @SuppressWarnings("SpringJavaAutowiringInspection")
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {

		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
				apiInfo()).includePatterns(".*api.*");//.includePatterns(".*api.*"); // assuming the API lives
														// at something like
														// http://myapp/api
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Hippo API List",
				"This is a description of your API.", "API",
				"me@wherever.com", "API License", "API License URL");
		return apiInfo;
	}
	
//	@Bean
//	public CommonsMultipartResolver multipartResolver(){
//	    CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//	    commonsMultipartResolver.setDefaultEncoding("utf-8");
//	    commonsMultipartResolver.setMaxUploadSize(50000000);
//	    return commonsMultipartResolver;
//	}
	
}