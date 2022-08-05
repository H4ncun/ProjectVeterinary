package com.gft.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Cliente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "tutor")
    private List<Animais> animais;


    public Cliente(Long id, List<Animais> animais) {
        super();
        this.id = id;
        this.animais = animais;
    }

    public Cliente(Long id, String nome, String sobrenome, Endereco Endereco, int telefone, List<Animais> animais) {
        super(nome, sobrenome, Endereco, telefone);
    }


}
