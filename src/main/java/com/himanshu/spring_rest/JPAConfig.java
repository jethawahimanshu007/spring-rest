package com.himanshu.spring_rest;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//This is to enable transactions in JPA
@EnableTransactionManagement
//This is to fetch value of propoerties from a properties file-- JPA properties and DB properties can be read!
//@PropertySource(value="classpath:application.properties")
public class JPAConfig {

	
	//This is to define the environment in Spring, merely to read properties from a property file
	//@Autowired
	//private Environment env;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setDataSource(getDataSource());
		//Set packages to scan for entity classes
		emf.setPackagesToScan("com.himanshu.spring_rest.entity");
		emf.setJpaProperties(jpaProperties());
		return emf;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dm=new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		dm.setUrl("jdbc:mysql://localhost:3306/example-db");
		dm.setUsername("root");
		dm.setPassword("root");
		//dm.setUrl(env.getProperty("db.url"));
		//dm.setUsername(env.getProperty("db.user"));
		//dm.setPassword(env.getProperty("password"));
		return dm;
	}
	
	@Bean
	public PlatformTransactionManager txnMgr(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	@Bean 
	public Properties jpaProperties() {
		Properties props=new Properties();
		props.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		
		props.put("hibernate.hbm2ddl.auto","create");
		props.put("hibernate.show_sql","true");
		props.put("hibernate.format_sql","true");
		/*
		props.put("hibernate.hbm2ddl.auto", env.getProperty("hbm2ddl.auto"));
		props.put("hibernate.show_sql", env.getProperty("show.sql"));
		props.put("hibernate.format_sql", env.getProperty("format.sql"));
		*/
		return props;
	}
}
