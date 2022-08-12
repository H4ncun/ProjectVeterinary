package com.gft.dto.registroAtendimento;

import com.gft.dto.animal.ResponseAnimalDTO;
import com.gft.dto.medico.ResponseMedicoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRegistroDTO {

    private Long id;

    private ResponseAnimalDTO animalID;

    private ResponseMedicoDTO medicoID;

    private LocalDate data;

    private String dadosAnimal;

    private String diagnostico;

    private String comentarios;


}
