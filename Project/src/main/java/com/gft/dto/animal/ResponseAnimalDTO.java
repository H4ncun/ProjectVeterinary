package com.gft.dto.animal;

import com.gft.entities.RegistroAtendimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAnimalDTO {

    private Long id;

    private String nome;

    private String raca;

    private LocalDate dataNascimento;

    private Long tutorID;

    private List<RegistroAtendimento> registroAtendimentos;


}
