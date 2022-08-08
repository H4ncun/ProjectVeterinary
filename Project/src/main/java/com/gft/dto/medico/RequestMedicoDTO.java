package com.gft.dto.medico;

import com.gft.dto.enderecoDTO.RequestEnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestMedicoDTO {
	
	private String nome;

    private String sobrenome;

    private RequestEnderecoDTO endereco;

    private int telefone;

	private BigDecimal salario;
}
