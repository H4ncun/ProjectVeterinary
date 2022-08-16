package com.gft.dto.enderecoDTO;


import com.gft.entities.Endereco;
import com.gft.formatting.Format;

public class EnderecoMapper {

    public static Endereco fromDTO(RequestEnderecoDTO dto) {
    	
        return new Endereco(null, dto.getNome(), new Format().formatCep(dto.getCep()), dto.getNumeroCasa(), dto.getComplemento());

    }

    public static ResponseEnderecoDTO fromEntity(Endereco endereco) {

        return new ResponseEnderecoDTO(endereco.getNome(), endereco.getCep(), endereco.getNumeroCasa(),endereco.getComplemento());
    }
}
