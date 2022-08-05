package com.gft.dto.ClienteDTO;

import com.gft.entities.Animais;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestDTO {

    private String nome;

    private String sobrenome;

    private Long enderecoID;

    private int telefone;

    private List<Animais> animais;

    public RequestDTO(String nome, String sobrenome, Long enderecoID, int telefone, List<Animais> animais) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.enderecoID = enderecoID;
        this.telefone = telefone;
        this.animais = animais;
    }
}
