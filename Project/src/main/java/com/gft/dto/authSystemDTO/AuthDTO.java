package com.gft.dto.authSystemDTO;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {

	@ApiModelProperty(value = "E-mail para o login", name = "email", dataType = "String", example = "cliente@gft.com")
	@NotBlank
    private String email;
	
	@ApiModelProperty(value = "Senha para o login", name = "senha", dataType = "String", example = "1234")
	@NotBlank
    private String password;

}
