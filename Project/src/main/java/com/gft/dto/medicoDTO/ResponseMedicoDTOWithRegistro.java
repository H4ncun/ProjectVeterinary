package com.gft.dto.medicoDTO;

import com.gft.dto.enderecoDTO.ResponseEnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMedicoDTOWithRegistro {

    private String nome;

    private String email;

    private String telefone;


}
