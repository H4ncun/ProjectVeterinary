package com.gft.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.dto.medico.MedicoMapper;
import com.gft.dto.medico.RequestMedicoDTO;
import com.gft.dto.medico.ResponseMedicoDTO;
import com.gft.entities.Medico;
import com.gft.service.MedicoService;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private MedicoService medicoService;

    @ApiOperation(value = "Retorna todos os médicos")
    @GetMapping
    public ResponseEntity<List<ResponseMedicoDTO>> listar() {
        return ResponseEntity.ok(medicoService.listar()
                .stream().map(MedicoMapper::fromEntity)
                .collect(Collectors.toList()));
    }

    @ApiOperation(value = "Retorna um médico pelo id informado")
    @GetMapping("/{medicoId}")
    public ResponseEntity<ResponseMedicoDTO> buscar(@PathVariable Long medicoId) {
        Medico medico = medicoService.buscar(medicoId);
        return ResponseEntity.ok(MedicoMapper.fromEntity(medico));
    }

    @ApiOperation(value = "Cria um médico")
    @PostMapping
    public ResponseEntity<ResponseMedicoDTO> salvar(@Valid @RequestBody RequestMedicoDTO dto) {
        Medico medico = medicoService.salvar(MedicoMapper.fromDTO(dto));
        return ResponseEntity.ok(MedicoMapper.fromEntity(medico));
    }

    @ApiOperation(value = "Atualiza os dados do médico informado pelo id")
    @PutMapping("/{medicoId}")
    public ResponseEntity<ResponseMedicoDTO> atualizar(@PathVariable Long medicoId, @Valid @RequestBody RequestMedicoDTO dto) {

        Medico medico = medicoService.atualizar(MedicoMapper.fromDTO(dto), medicoId);

        return ResponseEntity.ok(MedicoMapper.fromEntity(medico));
    }

    @ApiOperation(value = "Deleta os dados do médico informado pelo id")
    @DeleteMapping("/{medicoId}")
    public void remover(@PathVariable Long medicoId) {
        medicoService.excluir(medicoId);
    }
}
