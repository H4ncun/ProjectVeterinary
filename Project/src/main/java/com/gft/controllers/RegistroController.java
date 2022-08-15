package com.gft.controllers;

import javax.validation.Valid;

import com.gft.dto.animal.AnimalMapper;
import com.gft.dto.animal.ResponseAnimalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gft.dto.registroAtendimento.RegistroMapper;
import com.gft.dto.registroAtendimento.RequestRegistroDTO;
import com.gft.dto.registroAtendimento.ResponseRegistroDTO;
import com.gft.entities.Animal;
import com.gft.entities.Medico;
import com.gft.entities.RegistroAtendimento;
import com.gft.service.AnimalService;
import com.gft.service.MedicoService;
import com.gft.service.RegistroService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registros")
public class RegistroController {

    final RegistroService registroService;

    final MedicoService medicoService;

    final AnimalService animalService;

    public RegistroController(RegistroService registroService, MedicoService medicoService, AnimalService animalService) {
        this.registroService = registroService;
        this.medicoService = medicoService;
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity<ResponseRegistroDTO> salvarAnimal(@RequestBody @Valid RequestRegistroDTO dto) {

        RegistroAtendimento registro = registroService.salvar(RegistroMapper.fromDTO(dto));
        Animal animal = animalService.buscar(dto.getAnimalID());
        Medico medico = medicoService.buscar(dto.getMedicoID());

        registro.setAnimal(animal);
        registro.setMedico(medico);

        return ResponseEntity.ok(RegistroMapper.fromEntity(registro));
    }

    @GetMapping
    public ResponseEntity<List<ResponseRegistroDTO>> listar() {
        return ResponseEntity.ok(registroService.listar()
                .stream().map(RegistroMapper::fromEntity)
                .collect(Collectors.toList()));
    }

}
