package com.gft.dto.EnderecoDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {

    private String nome;
    private String cep;
    private String numeroCasa;
    private String complemento;

    public RequestDTO(String nome, String cep, String numeroCasa, String complemento) {
        this.nome = nome;
        this.cep = cep;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
    }
}
