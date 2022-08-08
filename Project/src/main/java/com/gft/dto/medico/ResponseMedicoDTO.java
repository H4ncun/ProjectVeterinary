package com.gft.dto.medico;

import java.math.BigDecimal;

import com.gft.dto.EnderecoDTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseMedicoDTO {

	private Long id;
	private BigDecimal salario;
	private String nome;

    private String sobrenome;

    private ResponseDTO endereco;

    private int telefone;
}
