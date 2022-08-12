package com.gft.service;

import com.gft.entities.Animal;
import com.gft.entities.Cliente;
import com.gft.exception.NegocioException;
import com.gft.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal salvar(Animal animal) {

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
                .orElseThrow(() -> new NegocioException("Animal não encontrado"));
    }

    public void deletarAnimal(Long id) {

        animalRepository.deleteById(id);
    }
}
