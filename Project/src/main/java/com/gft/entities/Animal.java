package com.gft.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    private String raca;

    private LocalDate dataNascimento;

    //@JsonIgnore
    @ManyToOne
    private Cliente tutor;

    @OneToMany(mappedBy = "animal")
    private List<RegistroAtendimento> registroAtendimentos;

	public Animal(Long id, String nome, String raca, LocalDate dataNascimento, Cliente tutor) {
		this.id = id;
		this.nome = nome;
		this.raca = raca;
		this.dataNascimento = dataNascimento;
		this.tutor = tutor;
	}

    
}
