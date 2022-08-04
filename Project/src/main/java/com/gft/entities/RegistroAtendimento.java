package com.gft.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegistroAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Animais animal;

    @ManyToOne
    private Medico medico;

    private Date data;

    private String dadosAnimal;

    private String diagnotico;

    private String comentarios;

}
