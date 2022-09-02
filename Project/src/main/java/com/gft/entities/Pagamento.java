package com.gft.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.gft.config.utils.TipoPagamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valor;
	private String formaPagamento;
	private String status = "Em Análise";
	
	@Transient
	private TipoPagamento infoPagamento;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Cliente cliente;

	public Pagamento(Long id, BigDecimal valor, String formaPagamento, TipoPagamento infoPagamento, Cliente cliente) {
		super();
		this.id = id;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
		this.status = "Em Análise";
		this.infoPagamento = infoPagamento;
		this.cliente = cliente;
	}
}
