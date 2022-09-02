package com.gft.dto.pagamentoDTO;

import com.gft.config.utils.TipoPagamento;
import com.gft.config.utils.VerificaTipoPagamento;
import com.gft.entities.Cliente;
import com.gft.entities.Pagamento;

public class PagamentoMapper {

	public static Pagamento fromDTO(RequestPagamentoDTO dto) {
		
		TipoPagamento tipo = new VerificaTipoPagamento().verificar(dto);
		return new Pagamento(null, dto.getValor(), dto.getFormaPagamento(), tipo, new Cliente(dto.getClienteId()));
	}
	
	public static ResponsePagamentoDTO fromEntity(Pagamento pagamento) {
		
		return new ResponsePagamentoDTO(pagamento.getValor(), pagamento.getFormaPagamento(),pagamento.getStatus(), pagamento.getCliente().getId());
	}
}
