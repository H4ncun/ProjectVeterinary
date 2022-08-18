package com.gft.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal salario;

    public Medico(Long id) {
        this.id = id;
    }

    public Medico(Long id, BigDecimal salario, String nome, Endereco endereco, String telefone,SystemUser systemUser) {
        super(nome, endereco, telefone,systemUser);
        this.salario = salario;
    }
}
