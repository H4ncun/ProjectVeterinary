package com.gft.service;

import com.gft.entities.Cliente;
import com.gft.repositories.ClienteRepo;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    final ClienteRepo clienteRepo;

    public ClienteService(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public void salvar(Cliente cliente){
        clienteRepo.save(cliente);
    }
}

