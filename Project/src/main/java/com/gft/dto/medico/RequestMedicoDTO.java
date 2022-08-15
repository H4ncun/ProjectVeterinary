package com.gft.dto.medico;

import com.gft.dto.enderecoDTO.RequestEnderecoDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestMedicoDTO {

    @ApiModelProperty(value = "Nome do médico", name = "nome", dataType = "String", example = "Rogério")
    @Size(min = 2, max = 100)
    @NotBlank
    private String nome;

    private RequestEnderecoDTO endereco;

    @ApiModelProperty(value = "Telefone do médico", name = "telefone", dataType = "String", example = "11946328416")
    @NotBlank
    private String telefone;

    @ApiModelProperty(value = "Salário do mmédico", name = "salario", dataType = "BigDecimal", example = "5200")
    @NotNull
    private BigDecimal salario;
}


