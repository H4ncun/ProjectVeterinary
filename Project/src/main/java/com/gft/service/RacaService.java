package com.gft.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gft.entities.Raca;
import com.gft.exception.EntidadeNaoEncontradaException;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class RacaService {

	private WebClient webClientDogApi;

	public Flux<Raca> obterRacaPorId(Long id) {

		Flux<Raca> responseBody = this.webClientDogApi
				.method(HttpMethod.GET)
				.uri("/{id}?", id)
				.retrieve()
				.bodyToFlux(Raca.class);
		if (responseBody.blockFirst().getId() == null) {
			throw new EntidadeNaoEncontradaException("Raça não encontrada");
		}
		return responseBody;
	}
	
	public Flux<Raca> listarRacas() {

		Flux<Raca> responseBody = this.webClientDogApi
				.method(HttpMethod.GET)
				.uri("/?")
				.retrieve()
				.bodyToFlux(Raca.class);
		
		return responseBody;


	}
	
	public Flux<Raca> buscarPorNome(String nome) {

		Flux<Raca> responseBody = this.webClientDogApi
				.method(HttpMethod.GET)
				.uri("/search?q={nome}", nome)
				.retrieve()
				.bodyToFlux(Raca.class);
		
		if (responseBody.blockFirst().getId() == null) {
			throw new EntidadeNaoEncontradaException("Raça não encontrada");
		}
		
		return responseBody;


	}
}
