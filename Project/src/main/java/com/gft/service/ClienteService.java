package com.gft.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Cliente;
import com.gft.exception.EntidadeNaoEncontradaException;
import com.gft.repositories.ClienteRepository;
import com.gft.repositories.EnderecoRepository;

@Service
public class ClienteService {

    final ClienteRepository clienteRepository;
    final EnderecoRepository enderecoRepository;

    public ClienteService(ClienteRepository clienteRepo, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepo;
		this.enderecoRepository = enderecoRepository;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarCliente(Long id) {

        return clienteRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente não encontrado"));
    }

    public Page<Cliente> listarCliente(Pageable page) {

        return clienteRepository.findAll(page);
    }

    public void deletarCliente(Long id) throws Exception {
        Cliente cliente = this.buscarCliente(id);

        clienteRepository.delete(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente, Long id) throws Exception {

    	Cliente clienteOriginal = this.buscarCliente(id);
        cliente.setId(clienteOriginal.getId());
        cliente.getEndereco().setId(clienteOriginal.getEndereco().getId());
        enderecoRepository.save(cliente.getEndereco());
        return clienteRepository.save(cliente);
    }
}

