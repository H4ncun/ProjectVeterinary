package com.gft.dto.clienteDTO;

import com.gft.dto.animal.AnimalMapper;
import com.gft.dto.enderecoDTO.EnderecoMapper;
import com.gft.entities.Cliente;
import com.gft.formatting.Format;


public class ClienteMapper {

    public static Cliente fromDTO(RequestClienteDTO dto) {

        return new Cliente(null, dto.getNome(), EnderecoMapper.fromDTO(dto.getEndereco()),
                new Format().formatNumberPhone(dto.getTelefone()));
    }

    public static ResponseClienteDTO fromEntity(Cliente cliente) {

        return new ResponseClienteDTO(cliente.getId(), cliente.getNome(), EnderecoMapper.fromEntity(cliente.getEndereco()), cliente.getTelefone(), AnimalMapper.toCollectionDTO(cliente.getAnimais()));
    }

}
