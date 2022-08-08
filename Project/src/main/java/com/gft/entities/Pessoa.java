package com.gft.entities;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Pessoa {

    private String nome;

    private String sobrenome;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Endereco Endereco;

    private int telefone;

}
