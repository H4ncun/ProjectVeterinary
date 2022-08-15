package com.gft.dto.clienteDTO;

import java.util.List;

import com.gft.dto.animal.ResponseAnimalDTO;
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

    private ResponseEnderecoDTO endereco;

    private String telefone;
    
    private List<ResponseAnimalDTO> animal;


}
