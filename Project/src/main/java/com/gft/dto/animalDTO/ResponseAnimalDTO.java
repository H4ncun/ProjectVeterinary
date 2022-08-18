package com.gft.dto.animalDTO;

import java.time.LocalDate;

import com.gft.entities.Raca;

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

    private Raca raca;

    private LocalDate dataNascimento;

    private Long tutorID;

}
