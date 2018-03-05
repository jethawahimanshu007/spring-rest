package com.himanshu.spring_rest;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//Return the application config class instance
		return new Class[] {WebConfig.class,JPAConfig.class,SwaggerConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		
		//This tells Spring to only consider the requests which have /api prefix in it.
		//This can also be useful to tell nginx later that if there are requests starting with /api, direct them to Tomcat
		//Otherwise, direct the request to some folder maybe to handle the static file requests.
		return new String[] {"/api/*"};
	}

}
