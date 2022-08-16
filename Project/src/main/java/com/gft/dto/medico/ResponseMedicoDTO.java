package com.gft.dto.medico;

import com.gft.dto.enderecoDTO.ResponseEnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseMedicoDTO {

	private Long id;
	
	private String nome;
	
	private BigDecimal salario;
	
	private String telefone;
	
    private ResponseEnderecoDTO endereco;
 
}
