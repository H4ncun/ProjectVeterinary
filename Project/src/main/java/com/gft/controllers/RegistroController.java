package com.gft.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.dto.registroAtendimentoDTO.RegistroMapper;
import com.gft.dto.registroAtendimentoDTO.RequestRegistroDTO;
import com.gft.dto.registroAtendimentoDTO.ResponseRegistroDTO;
import com.gft.entities.Animal;
import com.gft.entities.Medico;
import com.gft.entities.RegistroAtendimento;
import com.gft.service.AnimalService;
import com.gft.service.MedicoService;
import com.gft.service.RegistroService;

import io.swagger.annotations.ApiOperation;

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

    @ApiOperation(value = "Cria o registro com as informções referentes ao atendimento do animal")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
    @PostMapping
    public ResponseEntity<ResponseRegistroDTO> salvarRegistro(@RequestBody @Valid RequestRegistroDTO dto) {
        RegistroAtendimento registro = RegistroMapper.fromDTO(dto);
        Animal animal = animalService.buscar(dto.getAnimalID());
        Medico medico = medicoService.buscar(dto.getMedicoID());
        registro.setAnimal(animal);
        registro.setMedico(medico);
        registroService.salvar(registro);
        return ResponseEntity.ok(RegistroMapper.fromEntity(registro));
    }
    @ApiOperation(value = "Retorna todos os registros")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
    @GetMapping
    public ResponseEntity<List<ResponseRegistroDTO>> listar() {
        return ResponseEntity.ok(registroService.listar()
                .stream().map(RegistroMapper::fromEntity)
                .collect(Collectors.toList()));
    }
    @ApiOperation(value = "Retorna todos os registros do animal pelo cliente")
    @PreAuthorize("hasAnyAuthority('CLIENT')")
    @GetMapping("/animal/{id}")
    public ResponseEntity<List<ResponseRegistroDTO>> listaRegistroAnimal(@PathVariable Long id) {
        return ResponseEntity.ok(registroService.listarPeloIDAnimal(id)
                .stream().map(RegistroMapper::fromEntity)
                .collect(Collectors.toList()));
    }
}
