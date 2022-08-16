package com.gft.dto.enderecoDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseEnderecoDTO {

    private String nome;
    private String cep;
    private String numeroCasa;
    private String complemento;

    public ResponseEnderecoDTO(String nome, String cep, String numeroCasa, String complemento) {
        this.nome = nome;
        this.cep = cep;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
    }
}
