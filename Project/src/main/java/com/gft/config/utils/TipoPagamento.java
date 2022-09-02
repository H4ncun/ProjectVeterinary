package com.gft.config.utils;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.gft.dto.pagamentoDTO.RequestPagamentoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class TipoPagamento {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	
	@Transient
	protected TipoPagamento proximo;
	
	public TipoPagamento(TipoPagamento proximo) {
		this.proximo = proximo;
	}
	
	public TipoPagamento verificarTipo(RequestPagamentoDTO pagamento) {
		if(deveAplicar(pagamento)) {
			return populaDeAcordoComTipo(pagamento);
		}
		
		return proximo.verificarTipo(pagamento);
	}
	
	protected abstract TipoPagamento populaDeAcordoComTipo(RequestPagamentoDTO pagamento);
	protected abstract boolean deveAplicar(RequestPagamentoDTO pagamento);
}
