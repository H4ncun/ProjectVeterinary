package com.gft.dto.clienteDTO;

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
	@NotBlank
	@Size(max = 250)
    private String nome;

    private RequestEnderecoDTO endereco;

<<<<<<< HEAD
	@ApiModelProperty(value = "telefone do cliente", name = "telefone", dataType = "String", example = "11936482459")
    private String telefone;
=======
	@ApiModelProperty(value = "Telefone do cliente", name = "telefone", dataType = "int", example = "936482459")
	@NotNull
    private int telefone;
>>>>>>> a097b8d5505f7bcc0bd5731b7d91c7e30ec42646

}
