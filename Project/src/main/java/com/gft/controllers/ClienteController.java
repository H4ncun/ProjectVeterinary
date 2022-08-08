package com.gft.controllers;


import com.gft.dto.clienteDTO.ClienteMapper;
import com.gft.dto.clienteDTO.RequestClienteDTO;
import com.gft.dto.clienteDTO.ResponseClienteDTO;
import com.gft.entities.Cliente;
import com.gft.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ResponseClienteDTO> salvarCliente(@RequestBody @Valid RequestClienteDTO dto) {

        Cliente cliente = clienteService.salvar(ClienteMapper.fromDTO(dto));
        return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
    }


}
