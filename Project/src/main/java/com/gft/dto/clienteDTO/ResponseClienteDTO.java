package com.gft.dto.clienteDTO;

import com.gft.dto.enderecoDTO.ResponseEnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseClienteDTO {

    private Long id;
    private String nome;

    private String sobrenome;

    private ResponseEnderecoDTO endereco;

    private int telefone;


}
