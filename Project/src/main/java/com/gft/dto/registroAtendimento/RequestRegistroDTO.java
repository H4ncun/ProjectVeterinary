package com.gft.dto.registroAtendimento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestRegistroDTO {

    private Long animalID;

    private Long medicoID;

    private String dadosAnimal;

    private String diagnostico;

    private String comentarios;

}
