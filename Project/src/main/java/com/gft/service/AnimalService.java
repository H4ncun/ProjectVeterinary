package com.gft.service;

import com.gft.entities.Animal;
import com.gft.entities.Cliente;
import com.gft.entities.Raca;
import com.gft.exception.EntidadeNaoEncontradaException;
import com.gft.repositories.AnimalRepository;
import com.gft.repositories.RacaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;
    private ClienteService clienteService;
    private RacaService racaService;
    private RacaRepository racaRepository;

    public AnimalService(AnimalRepository animalRepository, ClienteService clienteService, RacaService racaService, RacaRepository racaRepository) {
        this.animalRepository = animalRepository;
        this.clienteService = clienteService;
        this.racaService = racaService;
        this.racaRepository = racaRepository;
    }

    @Transactional
    public Animal salvar(Animal animal) {
        clienteService.buscar(animal.getTutor().getId());
        Flux<Raca> raca = racaService.obterRacaPorId(animal.getRaca().getId());
        Raca racaBanco = racaRepository.save(raca.blockFirst());
        animal.setRaca(racaBanco);
        return animalRepository.save(animal);
    }

    public List<Animal> listar() {
        return animalRepository.findAll();
    }

    public List<Animal> listarPorClienteID(Long clienteId) {
        return animalRepository.findByTutor(new Cliente(clienteId));
    }

    public Animal buscar(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Animal não encontrado"));
    }

    @Transactional
    public Animal atualizar(Animal animal, Long id) {
        Animal animalOriginal = this.buscar(id);
        animal.setId(animalOriginal.getId());

        return animalRepository.save(animal);
    }

    @Transactional
    public void deletar(Long id) {
        Animal animal = this.buscar(id);
        animalRepository.delete(animal);
    }
}
