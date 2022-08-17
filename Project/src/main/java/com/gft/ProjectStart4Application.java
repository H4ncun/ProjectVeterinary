package com.gft;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ProjectStart4Application {
	
	@Value("${app.KeyTheDogApi}")
	private String X_API_KEY;
	
	@Value("${app.UrlTheDogApi}")
	private String URL_DOG_API;
	
	@Bean
	public WebClient webClientDogApi(WebClient.Builder builder) {
		return builder
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.baseUrl(URL_DOG_API)
			.defaultHeader("x-api-key", X_API_KEY)
			.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectStart4Application.class, args);
	}

}
