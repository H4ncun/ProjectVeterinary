package com.gft.entities;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@MappedSuperclass
public abstract class Pessoa {

    private String nome;

    private String sobrenome;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Endereco Endereco;

    private int telefone;

}
