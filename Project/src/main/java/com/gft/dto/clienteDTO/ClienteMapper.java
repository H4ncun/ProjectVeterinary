package com.gft.dto.clienteDTO;

import com.gft.dto.enderecoDTO.EnderecoMapper;
import com.gft.entities.Cliente;


public class ClienteMapper {


    public static Cliente fromDTO(RequestClienteDTO dto) {



        return new Cliente(null, dto.getNome(), dto.getSobrenome(), EnderecoMapper.fromDTO(dto.getEndereco()), dto.getTelefone());

    }

    public static ResponseClienteDTO fromEntity(Cliente cliente) {

        return new ResponseClienteDTO(cliente.getId(), cliente.getNome(), cliente.getSobrenome(), EnderecoMapper.fromEntity(cliente.getEndereco()), cliente.getTelefone());

    }

}
