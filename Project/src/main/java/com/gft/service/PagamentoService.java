package com.gft.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gft.config.utils.TipoPagamento;
import com.gft.entities.Pagamento;
import com.gft.repositories.PagamentoRepository;
import com.gft.repositories.TipoPagamentoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PagamentoService {

	private TipoPagamentoRepository tipoPagamentoRepository;
	private PagamentoRepository pagamentoRepository;
	
	@Transactional
	public Pagamento salvar(Pagamento pagamento, TipoPagamento tipoPagamento) {
		
		pagamentoRepository.save(pagamento);
		tipoPagamentoRepository.save(tipoPagamento);
		
		return pagamento;
		
	}
}
