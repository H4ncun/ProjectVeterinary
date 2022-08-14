package com.gft.dto.animal;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
