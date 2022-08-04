package com.gft.entities;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa {

    private String nome;

    private String sobrenome;

    @ManyToOne
    private Endereco Endereco;

    private int telefone;

}
