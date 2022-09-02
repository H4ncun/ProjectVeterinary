package com.gft.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.config.utils.TipoPagamento;
import com.gft.config.utils.VerificaTipoPagamento;
import com.gft.dto.pagamentoDTO.PagamentoMapper;
import com.gft.dto.pagamentoDTO.RequestPagamentoDTO;
import com.gft.dto.pagamentoDTO.ResponsePagamentoDTO;
import com.gft.entities.Pagamento;
import com.gft.service.PagamentoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pagamentos")
@PreAuthorize("hasAnyAuthority('CLIENT')")
@AllArgsConstructor
public class PagamentoController {
	
	private PagamentoService pagamentoService;
	
	@PostMapping
	public ResponseEntity<ResponsePagamentoDTO> pagar(@RequestBody RequestPagamentoDTO dto) {
		
		VerificaTipoPagamento tipoPagamento = new VerificaTipoPagamento();
		TipoPagamento tipo = tipoPagamento.verificar(dto);
		
		Pagamento pagamento = PagamentoMapper.fromDTO(dto);
		
		pagamentoService.salvar(pagamento, tipo);
		
		
		return ResponseEntity.ok(PagamentoMapper.fromEntity(pagamento));
	}
}
