package com.gft.dto.clienteDTO;

import com.gft.dto.enderecoDTO.RequestEnderecoDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestClienteDTO {

	@ApiModelProperty(value = "nome do cliente", name = "nome", dataType = "String", example = "Marcos")
    private String nome;

    private RequestEnderecoDTO endereco;

	@ApiModelProperty(value = "telefone do cliente", name = "telefone", dataType = "String", example = "11936482459")
    private String telefone;

}
