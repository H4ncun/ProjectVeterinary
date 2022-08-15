package com.gft.dto.animal;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestAnimalDTO {

    @ApiModelProperty(value = "Nome Animal", name = "nome", dataType = "String", example = "Trovão")
    private String nome;

    @ApiModelProperty(value = "Data de Nascimento Animal", name = "dataNascimento", dataType = "LocalDate",
            example =
                    "2016-06-08")
    private LocalDate dataNascimento;

    @ApiModelProperty(value = "Raça Animal", name = "raca", dataType = "String", example = "Pinscher")
    private String raca;

    @ApiModelProperty(value = "ID do Tutor", name = "tutorID", dataType = "Long", example = "1")
    private Long tutorID;

}
