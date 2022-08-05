package com.gft.dto.ClienteDTO;

import com.gft.entities.Cliente;
import com.gft.entities.Endereco;

public class ClienteMapper {



        public static Cliente fromDTO(RequestDTO dto) {

            Endereco endereco = new Endereco();
            endereco.setId(dto.getEnderecoID());

            return new Cliente(null,dto.getNome(),dto.getSobrenome(),endereco,dto.getTelefone(),dto.getAnimais());

        }

    public static ResponseDTO fromEntity(Cliente cliente) {

        return new ResponseDTO(cliente.getId(), cliente.get

    }



}
