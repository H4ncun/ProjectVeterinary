package com.gft.dto.registroAtendimento;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestRegistroDTO {

    @ApiModelProperty(value = "ID do Animal", name = "animalID", dataType = "Long", example = "1")
    @NotNull
    private Long animalID;

    @ApiModelProperty(value = "ID do Médico", name = "medicoID", dataType = "Long", example = "1")
    @NotNull
    private Long medicoID;

    @ApiModelProperty(value = "Dados Animal do dia", name = "dadosAnimal", dataType = "String", example = "Entrou com dor na perna")
    @NotBlank
    private String dadosAnimal;

    @ApiModelProperty(value = "Diagnostico dado pelo Médico", name = "diagnostico", dataType = "String", example = "Apenas um machucado simples, realizado o curativo no animal")
    @NotBlank
    private String diagnostico;

    @ApiModelProperty(value = "Comentarios do atendimento", name = "comentarios", dataType = "String", example = "Passado um remédio para a dor, Tutor deve aplicar 2x ao dia")
    @NotBlank
    private String comentarios;

}
