package com.gft.controllers;

import com.gft.dto.animal.AnimalMapper;
import com.gft.dto.animal.RequestAnimalDTO;
import com.gft.dto.animal.ResponseAnimalDTO;
import com.gft.entities.Animal;
import com.gft.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity<ResponseAnimalDTO> salvarAnimal(@RequestBody @Valid RequestAnimalDTO dto) {

        Animal animal = animalService.salvar(AnimalMapper.fromDTO(dto));
        return ResponseEntity.ok(AnimalMapper.fromEntity(animal));
    }
}
