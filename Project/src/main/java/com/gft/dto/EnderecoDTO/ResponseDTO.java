package com.gft.dto.EnderecoDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {

    private Long id;
    private String nome;
    private String cep;
    private String numeroCasa;
    private String complemento;

    public ResponseDTO(Long id, String nome, String cep, String numeroCasa, String complemento) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
    }
}
