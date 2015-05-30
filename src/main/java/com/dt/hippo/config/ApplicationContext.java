package com.dt.hippo.config;

import java.util.Properties;

import javax.annotation.Resource;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import com.dt.hippo.business.common.ConfigurationHelper;

@Configuration
@ComponentScan(basePackages = {"com.dt.hippo.service","com.dt.hippo.auto","com.dt.hippo.my", "com.dt.hippo.business"})//"com.dt.hippo.config",
@EnableTransactionManagement
//@EnableWebMvc
@ImportResource("classpath:applicationContext.xml")
@PropertySource("classpath:application.properties")
@Import({CacheConfig.class, PersistantConfig.class, SecurityConfig.class})//
@EnableAspectJAutoProxy
public class ApplicationContext {
    
//    private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/jsp/";
//    private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

    private static final String PROPERTY_NAME_MESSAGESOURCE_BASENAME = "message.source.basename";
    private static final String PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE = "message.source.use.code.as.default.message";
    
    @Resource
    private Environment environment;

//	@Bean
//	public JavaMailSenderImpl javaMailSenderImpl() {
//		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
//		mailSenderImpl.setHost(environment.getProperty("smtp.host"));
//		mailSenderImpl.setPort(environment.getProperty("smtp.port", Integer.class));
//		mailSenderImpl.setProtocol(environment.getProperty("smtp.protocol"));
//		mailSenderImpl.setUsername(environment.getProperty("smtp.username"));
//		mailSenderImpl.setPassword(environment.getProperty("smtp.password"));
//
//		Properties javaMailProps = new Properties();
//		javaMailProps.put("mail.smtp.auth", true);
//		javaMailProps.put("mail.smtp.starttls.enable", true);
//
//		mailSenderImpl.setJavaMailProperties(javaMailProps);
//
//		return mailSenderImpl;
//	}
    


    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename(environment.getRequiredProperty(PROPERTY_NAME_MESSAGESOURCE_BASENAME));
        messageSource.setUseCodeAsDefaultMessage(Boolean.parseBoolean(environment.getRequiredProperty(PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE)));
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    @Bean
    public ConfigurationHelper configure()
    {
    	ConfigurationHelper configure = new ConfigurationHelper();
    	String path = environment.getProperty("file.dir");
    	if(path == null)
    	{
    		path = System.getProperty("java.io.tmpdir");
    	}
    	configure.setFileDir(path);
    	return configure;
    }
    
	@Bean
	public VelocityEngine velocityEngine()
	{
		VelocityEngineFactoryBean factory = new VelocityEngineFactoryBean();
		factory
				.setResourceLoaderPath(environment
						.getRequiredProperty("velocity.resourceLoaderPath"));
		return  factory.getObject(); 
//		return velocityEngine;
	}
	
	@Bean	
	public JavaMailSender javaMailSender()
	{
		JavaMailSenderImpl mailsender = new JavaMailSenderImpl();
		mailsender.setHost(environment.getRequiredProperty("mail.host"));
		mailsender.setUsername(environment.getRequiredProperty("mail.username"));
		mailsender.setPassword(environment.getRequiredProperty("mail.password"));
		Properties mailProperty = new Properties();
		mailProperty.setProperty("mail.smtp.auth", "true");
		mailProperty.setProperty("mail.smtp.timeout", "25000");
		mailProperty.setProperty("mail.smtp.port", "465");
		mailProperty.setProperty("mail.smtp.socketFactory.port", "465");
		mailProperty.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		mailsender.setJavaMailProperties(mailProperty);
		return mailsender;
	}
//	<bean id="mailSender" class="org.springframework.mail.javamail.JavaMailSenderImpl">
//    <property name="host" value="${mail.host}"/>
//    <property name="username" value="${mail.username}"/>
//    <property name="password" value="${mail.password}"/>
//    <property name="javaMailProperties">  
//          <props>  
//              <prop key="mail.smtp.auth">true</prop>  
//              <prop key="mail.smtp.timeout">25000</prop>
//              <prop key="mail.smtp.port">465</prop>  
//              <prop key="mail.smtp.socketFactory.port">465</prop>  
//              <prop key="mail.smtp.socketFactory.class">javax.net.ssl.SSLSocketFactory </prop>
//          </props>  
//    </property>  
// </bean>
 
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
//        viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);
//
//        return viewResolver;
//    }
    
}
