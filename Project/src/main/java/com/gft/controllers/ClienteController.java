package com.gft.controllers;


import com.gft.dto.clienteDTO.ClienteMapper;
import com.gft.dto.clienteDTO.RequestClienteDTO;
import com.gft.dto.clienteDTO.ResponseClienteDTO;
import com.gft.entities.Cliente;
import com.gft.service.ClienteService;

import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
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
    @ApiOperation(value = "Retorna todos os clientes")
    @GetMapping
    public ResponseEntity<Page<ResponseClienteDTO>> listarCliente(@PageableDefault(sort = "id") Pageable page) {

        return ResponseEntity.ok(clienteService.listarCliente(page).map(ClienteMapper::fromEntity));
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
    @ApiOperation(value = "Retorna um cliente pelo id informado")
    @GetMapping("{id}")
    public ResponseEntity<ResponseClienteDTO> buscarCliente(@PathVariable Long id) throws Exception {

        Cliente cliente = clienteService.buscarCliente(id);

        return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
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
    @ApiOperation(value = "Cria um cliente")
    @PostMapping
    public ResponseEntity<ResponseClienteDTO> salvarCliente(@RequestBody @Valid RequestClienteDTO dto) {

        Cliente cliente = clienteService.salvar(ClienteMapper.fromDTO(dto));
        return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
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
    @ApiOperation(value = "Deleta os dados do cliente informado pelo id")
    @DeleteMapping("{id}")
    public ResponseEntity<ResponseClienteDTO> deletarCliente(@PathVariable Long id) throws Exception {

        clienteService.deletarCliente(id);

        return ResponseEntity.ok().build();
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
    @ApiOperation(value = "Atualiza os dados do cliente informado pelo id")
    @PutMapping("{id}")
    public ResponseEntity<ResponseClienteDTO> atualizarCliente(@Valid @RequestBody RequestClienteDTO dto, @PathVariable Long id) {

        Cliente cliente;
        try {
            cliente = clienteService.atualizarCliente(ClienteMapper.fromDTO(dto), id);
            return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
        } catch (Exception e) {

            return ResponseEntity.notFound().build();
        }
    }

}
