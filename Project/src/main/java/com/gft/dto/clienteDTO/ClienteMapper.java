package com.gft.dto.clienteDTO;

import com.gft.dto.animalDTO.AnimalMapper;
import com.gft.dto.enderecoDTO.EnderecoMapper;
import com.gft.entities.Cliente;
import com.gft.entities.SystemUser;
import com.gft.formatting.Format;


public class ClienteMapper {

    public static Cliente fromDTO(RequestClienteDTO dto) {

        return new Cliente(null, dto.getNome(), EnderecoMapper.fromDTO(dto.getEndereco()),
                new Format().formatNumberPhone(dto.getTelefone()), new SystemUser());
    }

    public static ResponseClienteDTO fromEntity(Cliente cliente) {

        return new ResponseClienteDTO(cliente.getId(), cliente.getNome(),
                cliente.getSystemUser().getEmail(),cliente.getTelefone(),
                EnderecoMapper.fromEntity(cliente.getEndereco()),
                AnimalMapper.toCollectionDTO(cliente.getAnimais()));
    }

}
