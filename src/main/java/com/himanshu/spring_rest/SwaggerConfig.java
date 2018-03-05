package com.himanshu.spring_rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
/*	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
								.pathMapping("/api/*")
								.select()
								.apis(RequestHandlerSelectors.any())
								.paths(PathSelectors.any())
								.build() 
								.apiInfo(getApiInfo());
	}*/
	
	public ApiInfo getApiInfo() {
		Contact contact=new Contact("admin","https://himanshu.com","hj5y3@mst.edu");
		//Title, Description, 
		ApiInfo apiInfo=new ApiInfo("Title of My Spring Rest Service", "Trying out desc of service","1.0.0","TnC", contact, "MIT", "I can put "
				+ "MIT licence link here", null);
		return apiInfo;
	}

}
