package com.gft.dto.enderecoDTO;


import com.gft.entities.Endereco;

public class EnderecoMapper {

    public static Endereco fromDTO(RequestEnderecoDTO dto) {

        return new Endereco(null, dto.getNome(), dto.getCep(), dto.getNumeroCasa(), dto.getComplemento());

    }

    public static ResponseEnderecoDTO fromEntity(Endereco endereco) {

        return new ResponseEnderecoDTO(endereco.getId(), endereco.getNome(), endereco.getCep(), endereco.getComplemento(), endereco.getNumeroCasa());
    }
}
