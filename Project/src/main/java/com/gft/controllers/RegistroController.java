package com.gft.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.dto.registroAtendimento.RegistroMapper;
import com.gft.dto.registroAtendimento.RequestRegistroDTO;
import com.gft.dto.registroAtendimento.ResponseRegistroDTO;
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

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Fields mismatch"),
            @ApiResponse(code = 401, message = "Access Denied"),
            @ApiResponse(code = 403, message = "Access forbidden"),
            @ApiResponse(code = 404, message = "Content not found"),
            @ApiResponse(code = 409, message = "Integrity error"),
            @ApiResponse(code = 500, message = "Internal server error"),
    })
    @ApiOperation(value = "Cria o registro com as informções referentes ao atendimento do animal")
    @PostMapping
    public ResponseEntity<ResponseRegistroDTO> salvarAnimal(@RequestBody @Valid RequestRegistroDTO dto) {

        RegistroAtendimento registro = registroService.salvar(RegistroMapper.fromDTO(dto));
        Animal animal = animalService.buscar(dto.getAnimalID());
        Medico medico = medicoService.buscar(dto.getMedicoID());

        registro.setAnimal(animal);
        registro.setMedico(medico);

        return ResponseEntity.ok(RegistroMapper.fromEntity(registro));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Fields mismatch"),
            @ApiResponse(code = 401, message = "Access Denied"),
            @ApiResponse(code = 403, message = "Access forbidden"),
            @ApiResponse(code = 404, message = "Content not found"),
            @ApiResponse(code = 409, message = "Integrity error"),
            @ApiResponse(code = 500, message = "Internal server error"),
    })
    @ApiOperation(value = "Retorna todos os registros")
    @GetMapping
    public ResponseEntity<List<ResponseRegistroDTO>> listar() {
        return ResponseEntity.ok(registroService.listar()
                .stream().map(RegistroMapper::fromEntity)
                .collect(Collectors.toList()));
    }

}
