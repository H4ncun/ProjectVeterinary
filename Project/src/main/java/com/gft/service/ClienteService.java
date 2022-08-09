package com.gft.service;

import com.gft.entities.Cliente;
import com.gft.exception.ClienteException;
import com.gft.repositories.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    final ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public Cliente buscarCliente(Long id) throws Exception {

        return clienteRepo.findById(id).orElseThrow(() -> new ClienteException("Não encontrado"));
    }

    public Page<Cliente> listarCliente(Pageable page) {

        return clienteRepo.findAll(page);
    }

    public void deletarCliente(Long id) throws Exception {
        Cliente cliente = this.buscarCliente(id);

        clienteRepo.delete(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente, Long id) throws Exception {

        Cliente oldCliente = this.buscarCliente(id);

        cliente.setId(oldCliente.getId());

        return clienteRepo.save(cliente);
    }
}

