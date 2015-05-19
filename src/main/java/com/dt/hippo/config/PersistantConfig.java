package com.dt.hippo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages={"com.dt.hippo.auto.data.repository.jpa","com.dt.hippo.my.repository"},entityManagerFactoryRef="entityManagerFactoryBean")
public class PersistantConfig {

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    private static final String PROPERTY_NAME_DATABASE_POOL_SIZE_MAXMIUM = "db.pool.size.maxmium";

	@Resource
	private Environment environment;

	@Bean
	public DataSource dataSource() throws IllegalStateException,
			PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));

		dataSource.setJdbcUrl(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUser(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		// cpds.setMinPoolSize(1);
		// cpds.setAcquireIncrement(1);
		dataSource.setMaxPoolSize(environment.getRequiredProperty(
				PROPERTY_NAME_DATABASE_POOL_SIZE_MAXMIUM, Integer.class));
		// cpds.setMaxIdleTime(120);

		// cpds.setAcquireRetryAttempts(1000);
		// cpds.setAcquireRetryDelay(5000);
		//
		// cpds.setAutomaticTestTable("connection_test");
		// cpds.setIdleConnectionTestPeriod(5);
		// cpds.setTestConnectionOnCheckin(true);
		//
		// cpds.setMaxStatements(600);
		// cpds.setMaxStatementsPerConnection(200);

		return dataSource;
	}

	@Bean
	public JpaTransactionManager transactionManager()
			throws ClassNotFoundException, IllegalStateException,
			PropertyVetoException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(entityManagerFactoryBean()
				.getObject());

		return transactionManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
			throws ClassNotFoundException, IllegalStateException,
			PropertyVetoException {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean
				.setPackagesToScan("com.dt.hippo.auto.model.jpa", "com.dt.hippo.my.jpa");
		entityManagerFactoryBean
				.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setMappingResources("orm.xml");
		// entityManagerFactoryBean.setPersistenceXmlLocation("classpath:persistence.xml");
		// entityManagerFactoryBean.setPersistenceUnitName("devFish");
		Properties jpaProterties = new Properties();
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment
				.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		// <property name="jpaVendorAdapter">
		// <bean
		// class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">
		// <property name="generateDdl" value="false"/>
		// <property name="showSql" value="false"/>
		// <property name="databasePlatform" value="${hibernate.dialect}"/>
		// </bean>
		// </property>
		// org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
		// jpaVendorAdapter = new
		// org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter();
		//
		// entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		// jpaProterties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY,
		// "org.hibernate.cfg.EJB3NamingStrategy");
		// <prop key="hibernate.schema_override">JBPM_SCHEMA</prop>
		// <prop key="hibernate.schema_override_classes">org.jbpm.*</prop>
		// jpaProterties.put("hibernate.schema_override", "mytest");
		// jpaProterties.put("hibernate.schema_override_classes",
		// "com.dt.hippo.datajpa.model.*");
		// jpaProterties.put("hibernate.default_catalog", "mytest");
		// jpaProterties.put("hibernate.catalog_override_classes",
		// "com.dt.hippo.datajpa.model.*");
		entityManagerFactoryBean.setJpaProperties(jpaProterties);

		return entityManagerFactoryBean;
	}
}
