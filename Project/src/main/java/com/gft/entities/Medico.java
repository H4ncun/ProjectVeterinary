package com.gft.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medico extends Pessoa {
	
	public Medico(Long id, BigDecimal salario, String nome, Endereco endereco, int telefone) {
		super(nome, endereco, telefone);
		this.salario = salario;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal salario;

}
