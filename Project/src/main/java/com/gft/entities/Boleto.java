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
public class Boleto extends TipoPagamento {
	
	private String codigo;
	private String vencimento;
	private String clienteId;
	
	public Boleto(TipoPagamento proximo) {
		super(proximo);
	}


	@Override
	protected TipoPagamento populaDeAcordoComTipo(RequestPagamentoDTO pagamento) {
		Gson mapper = new Gson();
		
		Boleto boleto = mapper.fromJson(pagamento.getInfoPagamento(), Boleto.class);

		return boleto;
	}

	@Override
	protected boolean deveAplicar(RequestPagamentoDTO pagamento) {
		return pagamento.getFormaPagamento().equals("Boleto");
	}

}
