package com.gft.dto.enderecoDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseEnderecoDTO {

    private Long id;
    private String nome;
    private String cep;
    private String numeroCasa;
    private String complemento;

    public ResponseEnderecoDTO(Long id, String nome, String cep, String numeroCasa, String complemento) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
    }
}
