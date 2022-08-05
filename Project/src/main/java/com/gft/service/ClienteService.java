package com.gft.service;

import com.gft.entities.Cliente;
import com.gft.repositories.ClienteRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    final ClienteRepo clienteRepo;

    public ClienteService(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepo.save(cliente);
    }
    public Cliente buscarCliente(Long id) throws Exception {
        Optional<Cliente> cliente = clienteRepo.findById(id);

        if (cliente.isEmpty()) {
            throw new Exception("Aluno não encontrado");
        }
        return cliente.get();
    }

    public Page<Cliente> listarCliente(Pageable page) {

        return clienteRepo.findAll(page);
    }

    public void deletarCliente(Long id) throws Exception {
        Cliente cliente = this.buscarCliente(id);

        clienteRepo.delete(cliente);
    }
}

