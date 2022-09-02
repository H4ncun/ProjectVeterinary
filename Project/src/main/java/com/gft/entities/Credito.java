package com.gft.entities;

import javax.persistence.Entity;

import com.gft.config.utils.TipoPagamento;
import com.gft.dto.pagamentoDTO.RequestPagamentoDTO;
import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Credito extends TipoPagamento {
	
	private String cvv;
	private String numeroCartao;
	private String clienteId;

	public Credito(TipoPagamento proximo) {
		super(proximo);
	}

	@Override
	protected TipoPagamento populaDeAcordoComTipo(RequestPagamentoDTO pagamento) {
		Gson mapper = new Gson();
		
		Credito credito = mapper.fromJson(pagamento.getInfoPagamento(), Credito.class);
		
		return credito;
	}

	@Override
	protected boolean deveAplicar(RequestPagamentoDTO pagamento) {
		return pagamento.getFormaPagamento().equals("Crédito");
	}

}
