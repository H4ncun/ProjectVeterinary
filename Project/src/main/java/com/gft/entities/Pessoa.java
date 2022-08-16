package com.gft.entities;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Pessoa {

    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco Endereco;

    private String telefone;

}
