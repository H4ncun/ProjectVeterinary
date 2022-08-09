package com.gft.dto.registroAtendimento;

import java.time.LocalDateTime;

import com.gft.dto.animal.RequestAnimalDTO;
import com.gft.dto.medico.RequestMedicoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestRegistroDTO {

	private Long id;
    private RequestAnimalDTO animal;
    private RequestMedicoDTO medico;
    private LocalDateTime data;
    private String dadosAnimal;
    private String diagnotico;
    private String comentarios;
}
