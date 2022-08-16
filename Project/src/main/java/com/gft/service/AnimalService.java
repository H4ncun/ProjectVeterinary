package com.gft.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gft.entities.Animal;
import com.gft.entities.Cliente;
import com.gft.exception.EntidadeNaoEncontradaException;
import com.gft.repositories.AnimalRepository;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;
    private ClienteService clienteService;

    public AnimalService(AnimalRepository animalRepository, ClienteService clienteService) {
        this.animalRepository = animalRepository;
        this.clienteService = clienteService;
    }

    @Transactional
    public Animal salvar(Animal animal) {
    	
    	clienteService.buscarCliente(animal.getTutor().getId());

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
