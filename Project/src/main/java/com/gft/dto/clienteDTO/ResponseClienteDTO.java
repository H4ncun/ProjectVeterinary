package com.gft.dto.clienteDTO;

import com.gft.dto.animalDTO.ResponseAnimalDTO;
import com.gft.dto.enderecoDTO.ResponseEnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseClienteDTO {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private ResponseEnderecoDTO endereco;


    private List<ResponseAnimalDTO> animal;


}
