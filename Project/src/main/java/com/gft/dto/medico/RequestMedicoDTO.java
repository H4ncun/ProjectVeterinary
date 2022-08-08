package com.gft.dto.medico;

import java.math.BigDecimal;

import com.gft.dto.EnderecoDTO.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestMedicoDTO {
	
	private String nome;

    private String sobrenome;

    private RequestDTO endereco;

    private int telefone;

	private BigDecimal salario;
}
