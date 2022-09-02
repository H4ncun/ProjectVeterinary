package com.gft.config.utils;

import com.gft.dto.pagamentoDTO.RequestPagamentoDTO;
import com.gft.entities.Boleto;
import com.gft.entities.Credito;

public class VerificaTipoPagamento {

	public TipoPagamento verificar(RequestPagamentoDTO pagamento) {
		TipoPagamento cadeiaDeTipos = new Credito(
				new Boleto(
						new PagamentoIndefinido()));
		
		return cadeiaDeTipos.verificarTipo(pagamento);
	}
}
