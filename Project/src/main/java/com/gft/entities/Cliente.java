package com.gft.entities;

import lombok.*;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "tutor")
    private List<Animais> animais;

    public Cliente(Long id,String nome, String sobrenome, Endereco endereco, int telefone, List<Animais> animais) {
        super();
    }

    }
