package com.gft.dto.pagamentoDTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestPagamentoDTO {

	private BigDecimal valor;
	
	private String formaPagamento;
	
	private String infoPagamento;
	
	private Long clienteId;
}
