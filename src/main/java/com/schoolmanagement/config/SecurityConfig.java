package com.schoolmanagement.config;


import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages= {"com.schoolmanagement"})
@PropertySource("classpath:persistence-mysql.properties")
@EnableTransactionManagement
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//set up variable to hold properties
	@Autowired
	private Environment env;
	
	//setup logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	//define bean for our security datasource
	@Bean
	public DataSource securityDataSource () {
		
		//create connection pool
		ComboPooledDataSource securityDatasource = new ComboPooledDataSource();
		
		//set jdbc driver class
		try {
			securityDatasource.setDriverClass(env.getProperty("jdbc.driver"));
		}
		catch(PropertyVetoException exc)
		{
			throw new RuntimeException(exc);
		}
		
		//log connection properties
		logger.info(" ===> jdbc url: " + env.getProperty("jdbc.url"));
		logger.info(" ===> jdbc user: " + env.getProperty("jdbc.user"));
		
		//set database connection
		securityDatasource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDatasource.setUser(env.getProperty("jdbc.user"));
		securityDatasource.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool
		securityDatasource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDatasource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDatasource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDatasource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDatasource;
	}
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(securityDataSource());
        sessionFactory.setPackagesToScan(new String[] {
            "com.schoolmanagement.entity"
        });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }
	
	@Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
	
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				//.loginPage("/loginPage")
				.loginProcessingUrl("/authenticateUser")
				.defaultSuccessUrl("/student/list")
				.permitAll();
	}
}
