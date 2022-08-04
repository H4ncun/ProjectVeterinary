package com.gft.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Animais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String raca;

    private Date dataNascimento;
    @ManyToOne
    private Cliente tutor;

    @OneToMany(mappedBy = "animal")
    private List<RegistroAtendimento> registroAtendimentos;


}
