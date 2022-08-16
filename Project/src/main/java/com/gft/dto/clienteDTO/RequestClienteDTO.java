package com.gft.dto.clienteDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @ApiModelProperty(value = "Nome do cliente", name = "nome", dataType = "String", example = "Marcos")
    @Size(min = 2, max = 100)
    private String nome;

    @Valid
    @NotNull
    private RequestEnderecoDTO endereco;

    @ApiModelProperty(value = "telefone do cliente", name = "telefone", dataType = "String", example = "11936482459")
    @NotBlank
    private String telefone;


}
