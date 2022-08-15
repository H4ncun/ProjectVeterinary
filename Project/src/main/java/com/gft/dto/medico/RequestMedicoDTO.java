package com.gft.dto.medico;

import com.gft.dto.enderecoDTO.RequestEnderecoDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestMedicoDTO {
	
	@ApiModelProperty(value = "Nome do médico", name = "nome", dataType = "String", example = "Rogério")
	@NotBlank
	@Size(max = 250)
	private String nome;

    private RequestEnderecoDTO endereco;

    @ApiModelProperty(value = "Telefone do médico", name = "telefone", dataType = "int", example = "946328416")
    @NotNull
    private int telefone;

    @ApiModelProperty(value = "Salário do mmédico", name = "salario", dataType = "BigDecimal", example = "5200")
    @NotNull
	private BigDecimal salario;
}
