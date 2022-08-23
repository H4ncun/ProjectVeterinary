package com.gft.controllers;


import com.gft.dto.clienteDTO.ClienteMapper;
import com.gft.dto.clienteDTO.RequestClienteDTO;
import com.gft.dto.clienteDTO.ResponseClienteDTO;
import com.gft.entities.Cliente;
import com.gft.entities.SystemUser;
import com.gft.entities.TipoUser;
import com.gft.repositories.TipoUserRepository;
import com.gft.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    final ClienteService clienteService;
    final TipoUserRepository tipoUserRepository;

    public ClienteController(ClienteService clienteService, TipoUserRepository tipoUserRepository) {
        this.clienteService = clienteService;
        this.tipoUserRepository = tipoUserRepository;
    }

    @ApiOperation(value = "Retorna todos os clientes")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
    @GetMapping
    public ResponseEntity<Page<ResponseClienteDTO>> listarCliente(@PageableDefault(sort = "id") Pageable page) {
        return ResponseEntity.ok(clienteService.listar(page).map(ClienteMapper::fromEntity));
    }

    @ApiOperation(value = "Retorna um cliente pelo id informado")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
    @GetMapping("{id}")
    public ResponseEntity<ResponseClienteDTO> buscarCliente(@PathVariable Long id) throws Exception {
        Cliente cliente = clienteService.buscar(id);
        return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
    }

    @ApiOperation(value = "Cria um cliente")
    @PostMapping
    public ResponseEntity<ResponseClienteDTO> salvarCliente(@RequestBody @Valid RequestClienteDTO dto) {
        Cliente cliente = ClienteMapper.fromDTO(dto);
        SystemUser userClient = new SystemUser(null, dto.getEmail(),
                new BCryptPasswordEncoder().encode(dto.getPassword()), new TipoUser());
        cliente.setSystemUser(userClient);
        clienteService.salvar(cliente);
        return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
    }

    @ApiOperation(value = "Deleta os dados do cliente informado pelo id")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<ResponseClienteDTO> deletarCliente(@PathVariable Long id) throws Exception {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Atualiza os dados do cliente informado pelo id")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
    @PutMapping("{id}")
    public ResponseEntity<ResponseClienteDTO> atualizarCliente(@Valid @RequestBody RequestClienteDTO dto, @PathVariable Long id) {
        Cliente cliente;
        try {
            cliente = clienteService.atualizar(ClienteMapper.fromDTO(dto), id);
            return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
