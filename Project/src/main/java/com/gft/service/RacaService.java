package com.gft.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gft.entities.Raca;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class RacaService {

	private WebClient webClientDogApi;

	public Flux<Raca> obterRacaPorId(Long id) {

		Flux<Raca> responseBody = this.webClientDogApi
				.method(HttpMethod.GET)
				.uri("https://api.thedogapi.com/v1/breeds/{id}?api_key=461e06fd-c361-4327-ba81-bee2f3a34c31", id)
				.retrieve()
				.bodyToFlux(Raca.class);
		
		return responseBody;
	}
	
	public Flux<Raca> listarRacas() {

		Flux<Raca> responseBody = this.webClientDogApi
				.method(HttpMethod.GET)
				.uri("https://api.thedogapi.com/v1/breeds/?api_key=461e06fd-c361-4327-ba81-bee2f3a34c31")
				.retrieve()
				.bodyToFlux(Raca.class);
		
		return responseBody;


	}
	
	public Flux<Raca> buscarPorNome(String nome) {

		Flux<Raca> responseBody = this.webClientDogApi
				.method(HttpMethod.GET)
				.uri("https://api.thedogapi.com/v1/breeds/search?api_key=461e06fd-c361-4327-ba81-bee2f3a34c31&q={nome}", nome)
				.retrieve()
				.bodyToFlux(Raca.class);
		
		return responseBody;


	}
}
