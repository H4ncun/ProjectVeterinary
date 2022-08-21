package com.gft.service;

import com.gft.entities.Cliente;
import com.gft.entities.TipoUser;
import com.gft.exception.EntidadeNaoEncontradaException;
import com.gft.repositories.ClienteRepository;
import com.gft.repositories.EnderecoRepository;
import com.gft.repositories.TipoUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    final ClienteRepository clienteRepository;
    final EnderecoRepository enderecoRepository;
    final TipoUserRepository tipoUserRepository;

    public ClienteService(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, TipoUserRepository tipoUserRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.tipoUserRepository = tipoUserRepository;
    }

    @Transactional
    public void salvar(Cliente cliente) {
        TipoUser tipo = tipoUserRepository.findByTipo("CLIENT");
        cliente.getSystemUser().setTipo(tipo);
        clienteRepository.save(cliente);
    }

    public Cliente buscarCliente(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente não encontrado"));
    }

    public Page<Cliente> listarCliente(Pageable page) {
        return clienteRepository.findAll(page);
    }

    @Transactional
    public void deletarCliente(Long id) throws Exception {
        Cliente cliente = this.buscarCliente(id);
        clienteRepository.delete(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente, Long id) throws Exception {
        Cliente clienteOriginal = this.buscarCliente(id);
        cliente.setId(clienteOriginal.getId());
        cliente.getEndereco().setId(clienteOriginal.getEndereco().getId());
        cliente.setSystemUser((clienteOriginal.getSystemUser()));
        enderecoRepository.save(cliente.getEndereco());
        return clienteRepository.save(cliente);
    }
}

