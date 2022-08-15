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

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Endereco Endereco;

    private String telefone;

}
