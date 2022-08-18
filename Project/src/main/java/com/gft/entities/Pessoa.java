package com.gft.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Pessoa {

    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "system_user_id")
    private SystemUser systemUser;

}
