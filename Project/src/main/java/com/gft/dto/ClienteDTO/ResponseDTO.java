package com.gft.dto.ClienteDTO;

import java.util.List;

import com.gft.entities.Animais;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {

    private Long id;
    private String nome;

    private String sobrenome;

    private Long enderecoID;

    private int telefone;

    private List<Animais> animais;

    public ResponseDTO(Long id,String nome, String sobrenome, Long enderecoID, int telefone, List<Animais> animais) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.enderecoID = enderecoID;
        this.telefone = telefone;
        this.animais = animais;
    }
}
