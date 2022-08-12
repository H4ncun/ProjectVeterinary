package com.gft.controllers;

import com.gft.dto.animal.AnimalMapper;
import com.gft.dto.animal.RequestAnimalDTO;
import com.gft.dto.animal.ResponseAnimalDTO;
import com.gft.dto.registroAtendimento.RegistroMapper;
import com.gft.dto.registroAtendimento.RequestRegistroDTO;
import com.gft.dto.registroAtendimento.ResponseRegistroDTO;
import com.gft.entities.Animal;
import com.gft.entities.Medico;
import com.gft.entities.RegistroAtendimento;
import com.gft.service.AnimalService;
import com.gft.service.MedicoService;
import com.gft.service.RegistroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

        RegistroAtendimento registro = RegistroMapper.fromDTO(dto);
        Animal animal = animalService.buscar(dto.getAnimalID());
        Medico medico = medicoService.buscar(dto.getMedicoID());

        registro.setAnimal(animal);
        registro.setMedico(medico);
        registroService.salvar(registro);

        return ResponseEntity.ok(RegistroMapper.fromEntity(registro));
    }

}
