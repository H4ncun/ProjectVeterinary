package com.gft.dto.animalDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestAnimalDTO {

    @ApiModelProperty(value = "Nome Animal", name = "nome", dataType = "String", example = "Trovão")
    @NotBlank
    @Size(max = 150)
    private String nome;

    @ApiModelProperty(value = "Data de Nascimento Animal", name = "dataNascimento", dataType = "LocalDate", example ="2016-06-08")
    @NotNull
    private LocalDate dataNascimento;

    @ApiModelProperty(value = "Id do Animal", name = "racaId", dataType = "int", example = "Pinscher")
    @NotNull
    private Long racaId;

    @ApiModelProperty(value = "ID do Tutor", name = "tutorID", dataType = "Long", example = "1")
    @NotNull
    private Long tutorID;

}