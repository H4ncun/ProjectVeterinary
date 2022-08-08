package com.gft.service;

import com.gft.entities.Animal;
import com.gft.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal salvar(Animal animal) {

        return animalRepository.save(animal);
    }
}
