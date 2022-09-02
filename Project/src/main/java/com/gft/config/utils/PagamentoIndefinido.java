package com.gft.config.utils;

import com.gft.dto.pagamentoDTO.RequestPagamentoDTO;

public class PagamentoIndefinido extends TipoPagamento {

	public PagamentoIndefinido() {
		super(null);
	}

	@Override
	protected TipoPagamento populaDeAcordoComTipo(RequestPagamentoDTO pagamento) {
		return null;
	}

	@Override
	protected boolean deveAplicar(RequestPagamentoDTO pagamento) {
		return true;
	}

}
