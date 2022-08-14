package com.gft.dto.registroAtendimento;

import java.time.LocalDate;

import com.gft.dto.animal.ResponseAnimalDTO;
import com.gft.dto.medico.ResponseMedicoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRegistroDTO {

    private Long id;

    private ResponseAnimalDTO animal;

    private ResponseMedicoDTO medico;

    private LocalDate data;

    private String dadosAnimal;

    private String diagnostico;

    private String comentarios;


}
