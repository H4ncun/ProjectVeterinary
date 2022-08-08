package com.gft.dto.enderecoDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestEnderecoDTO {

    private String nome;
    private String cep;
    private String numeroCasa;
    private String complemento;

    public RequestEnderecoDTO(String nome, String cep, String numeroCasa, String complemento) {
        this.nome = nome;
        this.cep = cep;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
    }
}
