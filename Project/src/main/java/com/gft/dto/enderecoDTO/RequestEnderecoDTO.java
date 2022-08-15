
package com.gft.dto.enderecoDTO;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestEnderecoDTO {

    @ApiModelProperty(value = "nome da rua", name = "nome", dataType = "String", example = "Rua das Oliveiras")
    @NotBlank
    private String nome;
    
    @ApiModelProperty(value = "cep da rua", name = "cep", dataType = "String", example = "93684381")
    @NotBlank
    private String cep;
    
    @ApiModelProperty(value = "número da casa", name = "numeroCasa", dataType = "String", example = "652")
    @NotBlank
    private String numeroCasa;
    
    @ApiModelProperty(value = "complemento do endereço", name = "complemento", dataType = "String", example = "Apartemento 41C")
    @NotBlank
    private String complemento;

    public RequestEnderecoDTO(String nome, String cep, String numeroCasa, String complemento) {
        this.nome = nome;
        this.cep = cep;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
    }
}

