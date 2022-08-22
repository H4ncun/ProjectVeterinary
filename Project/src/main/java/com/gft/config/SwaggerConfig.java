package com.gft.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.gft.controllers"))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo())
          .securityContexts(Arrays.asList(securityContext()))
          .securitySchemes(Arrays.asList(apiKey()))
          .useDefaultResponseMessages(false)
          .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
          .globalResponseMessage(RequestMethod.PUT, responseMessageForPUT())
          .globalResponseMessage(RequestMethod.POST, responseMessageForPOST())
          .globalResponseMessage(RequestMethod.DELETE, responseMessageForDEL());
    }
	
	private ApiInfo apiInfo() {

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title ("Desafio API GFT")
                .description ("API desenvolvida para o desafio API GFT ")
                .version("1.0.0")
                .build();

        return apiInfo;
    }
	
	private ApiKey apiKey() { 
	    return new ApiKey("JWT", "Authorization", "header"); 
	}
	
	private SecurityContext securityContext() { 
	    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
	} 

	private List<SecurityReference> defaultAuth() { 
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
	    authorizationScopes[0] = authorizationScope; 
	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
	}

	
	private List<ResponseMessage> responseMessageForGET() {
	    return new ArrayList<ResponseMessage>() {
	    	
			private static final long serialVersionUID = 1L;

		{
	        add(new ResponseMessageBuilder()
	            .code(500)
	            .message("Internal server error")
	            .responseModel(new ModelRef("Error"))
	            .build());
	        add(new ResponseMessageBuilder()
	            .code(404)
	            .message("Content not found")
	            .build());
	        add(new ResponseMessageBuilder()
		         .code(403)
		         .message("Access forbidden")
		         .build());
	        add(new ResponseMessageBuilder()
		         .code(401)
		         .message("Access Denied")
		         .build());
	    }};
	}
	
	private List<ResponseMessage> responseMessageForPOST() {
	    return new ArrayList<ResponseMessage>() {
	    	
			private static final long serialVersionUID = 1L;

		{
	        add(new ResponseMessageBuilder()
	            .code(500)
	            .message("Internal server error")
	            .responseModel(new ModelRef("Error"))
	            .build());
	        add(new ResponseMessageBuilder()
	            .code(404)
	            .message("Content not found")
	            .build());
	        add(new ResponseMessageBuilder()
			    .code(403)
			    .message("Access forbidden")
			    .build());
		    add(new ResponseMessageBuilder()
			    .code(401)
			    .message("Access Denied")
			    .build());
	        add(new ResponseMessageBuilder()
		        .code(400)
		        .message("Bad request")
		        .build());
	    }};
	}
	
	private List<ResponseMessage> responseMessageForPUT() {
	    return new ArrayList<ResponseMessage>() {
	    	
			private static final long serialVersionUID = 1L;

		{
	        add(new ResponseMessageBuilder()
	            .code(500)
	            .message("Internal server error")
	            .responseModel(new ModelRef("Error"))
	            .build());
	        add(new ResponseMessageBuilder()
	            .code(404)
	            .message("Content not found")
	            .build());
	        add(new ResponseMessageBuilder()
				.code(403)
				.message("Access forbidden")
				.build());
			add(new ResponseMessageBuilder()
				.code(401)
				.message("Access Denied")
				.build());
	        add(new ResponseMessageBuilder()
		        .code(400)
		        .message("Bad request")
		        .build());
	    }};
	}
	
	private List<ResponseMessage> responseMessageForDEL() {
	    return new ArrayList<ResponseMessage>() {
	    	
			private static final long serialVersionUID = 1L;

		{
	        add(new ResponseMessageBuilder()
	            .code(500)
	            .message("Internal server error")
	            .responseModel(new ModelRef("Error"))
	            .build());
	        add(new ResponseMessageBuilder()
	            .code(404)
	            .message("Content not found")
	            .build());
	        add(new ResponseMessageBuilder()
				.code(403)
				.message("Access forbidden")
				.build());
			add(new ResponseMessageBuilder()
				.code(401)
				.message("Access Denied")
				.build());
	    }};
	}
}
