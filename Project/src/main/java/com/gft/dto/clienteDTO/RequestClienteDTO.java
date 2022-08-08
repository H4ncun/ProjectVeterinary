package com.gft.dto.clienteDTO;

import com.gft.dto.enderecoDTO.RequestEnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestClienteDTO {

    private String nome;

    private String sobrenome;

    private RequestEnderecoDTO endereco;

    private int telefone;

}
