package com.gft.controllers;


import com.gft.dto.clienteDTO.ClienteMapper;
import com.gft.dto.clienteDTO.RequestClienteDTO;
import com.gft.dto.clienteDTO.ResponseClienteDTO;
import com.gft.entities.Cliente;
import com.gft.service.ClienteService;
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



    @GetMapping
    public ResponseEntity<Page<ResponseClienteDTO>> listarCliente(@PageableDefault(sort = "id") Pageable page) {

        return ResponseEntity.ok(clienteService.listarCliente(page).map(ClienteMapper::fromEntity));
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseClienteDTO> buscarCliente(@PathVariable Long id) throws Exception {

        Cliente cliente = clienteService.buscarCliente(id);

        return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
    }

    @PostMapping
    public ResponseEntity<ResponseClienteDTO> salvarCliente(@RequestBody @Valid RequestClienteDTO dto) {

        Cliente cliente = clienteService.salvar(ClienteMapper.fromDTO(dto));
        return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseClienteDTO> deletarCliente(@PathVariable Long id) throws Exception {

        clienteService.deletarCliente(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseClienteDTO> atualizarCliente(@RequestBody RequestClienteDTO dto, @PathVariable Long id) {

        Cliente cliente;
        try {
            cliente = clienteService.atualizarCliente(ClienteMapper.fromDTO(dto), id);
            return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
        } catch (Exception e) {

            return ResponseEntity.notFound().build();
        }
    }

}
