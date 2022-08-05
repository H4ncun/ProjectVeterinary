package com.gft.dto.EnderecoDTO;


import com.gft.entities.Endereco;

public class EnderecoMapper {

    public static Endereco fromDTO(RequestDTO dto) {

        return new Endereco(null, dto.getNome(), dto.getCep(), dto.getNumeroCasa(), dto.getComplemento());

    }

    public static ResponseDTO fromEntity(Endereco endereco) {

        return new ResponseDTO(endereco.getId(), endereco.getNome(), endereco.getCep(), endereco.getComplemento(), endereco.getNumeroCasa());
    }
}
