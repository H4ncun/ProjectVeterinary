package com.gft.controllers;

import com.gft.dto.medico.MedicoMapper;
import com.gft.dto.medico.RequestMedicoDTO;
import com.gft.dto.medico.ResponseMedicoDTO;
import com.gft.entities.Medico;
import com.gft.service.MedicoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private MedicoService medicoService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Fields mismatch"),
            @ApiResponse(code = 401, message = "Access Denied"),
            @ApiResponse(code = 403, message = "Access forbidden"),
            @ApiResponse(code = 404, message = "Content not found"),
            @ApiResponse(code = 409, message = "Integrity error"),
            @ApiResponse(code = 500, message = "Internal server error"),
    })
    @ApiOperation(value = "Retorna todos os médicos")
    @GetMapping
    public ResponseEntity<List<ResponseMedicoDTO>> listar() {
        return ResponseEntity.ok(medicoService.listar()
                .stream().map(MedicoMapper::fromEntity)
                .collect(Collectors.toList()));
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
    @ApiOperation(value = "Retorna um médico pelo id informado")
    @GetMapping("/{medicoId}")
    public ResponseEntity<ResponseMedicoDTO> buscar(@PathVariable Long medicoId) {
        Medico medico = medicoService.buscar(medicoId);
        return ResponseEntity.ok(MedicoMapper.fromEntity(medico));
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
    @ApiOperation(value = "Cria um médico")
    @PostMapping
    public ResponseEntity<ResponseMedicoDTO> salvar(@Valid @RequestBody RequestMedicoDTO dto) {
        Medico medico = medicoService.salvar(MedicoMapper.fromDTO(dto));
        return ResponseEntity.ok(MedicoMapper.fromEntity(medico));
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
    @ApiOperation(value = "Atualiza os dados do médico informado pelo id")
    @PutMapping("/{medicoId}")
    public ResponseEntity<ResponseMedicoDTO> atualizar(@PathVariable Long medicoId, @Valid @RequestBody RequestMedicoDTO dto) {

        Medico medico = medicoService.atualizar(MedicoMapper.fromDTO(dto), medicoId);

        return ResponseEntity.ok(MedicoMapper.fromEntity(medico));
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
    @ApiOperation(value = "Deleta os dados do médico informado pelo id")
    @DeleteMapping("/{medicoId}")
    public void remover(@PathVariable Long medicoId) {
        medicoService.excluir(medicoId);
    }
}
