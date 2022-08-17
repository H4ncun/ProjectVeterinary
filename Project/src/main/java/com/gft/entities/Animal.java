package com.gft.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Raca raca;

    private LocalDate dataNascimento;

    @ManyToOne
    private Cliente tutor;

    public Animal(Long id) {
    	this.id = id;
    }
}
