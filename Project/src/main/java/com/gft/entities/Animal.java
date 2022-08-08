package com.gft.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String raca;

    private LocalDate dataNascimento;

    @ManyToOne
    private Cliente tutor;

    @OneToMany(mappedBy = "animal")
    private List<RegistroAtendimento> registroAtendimentos;

    public Animal(Long id, String nome, String raca, LocalDate now, Cliente cliente) {
    }
}
