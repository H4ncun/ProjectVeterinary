package com.gft.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.REMOVE)
    private List<Animal> animais = new ArrayList<>();

    public Cliente(Long id, String nome, Endereco endereco, String telefone, SystemUser systemUser) {
        super(nome, endereco, telefone, systemUser);
    }

    public Cliente(Long id) {
        this.id = id;
    }


}
