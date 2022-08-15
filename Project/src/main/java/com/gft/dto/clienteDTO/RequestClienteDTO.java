package com.gft.dto.clienteDTO;

import com.gft.dto.enderecoDTO.RequestEnderecoDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestClienteDTO {

    @ApiModelProperty(value = "Nome do cliente", name = "nome", dataType = "String", example = "Marcos")
    @NotBlank
    @Size(max = 250)
    private String nome;

    private RequestEnderecoDTO endereco;

    @ApiModelProperty(value = "telefone do cliente", name = "telefone", dataType = "String", example = "11936482459")
    private String telefone;


}
