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
public class RequestAnimalDTO {

    private String nome;
    
    private LocalDate dataNascimento;

    private String raca;

    private Long tutorID;

}
