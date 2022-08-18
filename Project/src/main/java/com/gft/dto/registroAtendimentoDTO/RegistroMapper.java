package com.gft.dto.registroAtendimentoDTO;

import com.gft.dto.animalDTO.AnimalMapper;
import com.gft.dto.medicoDTO.MedicoMapper;
import com.gft.entities.Animal;
import com.gft.entities.Medico;
import com.gft.entities.RegistroAtendimento;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RegistroMapper {

    public static RegistroAtendimento fromDTO(RequestRegistroDTO dto) {

        return new RegistroAtendimento(null, new Animal(dto.getAnimalID()), new Medico(dto.getMedicoID()), LocalDate.now(), dto.getDadosAnimal(), dto.getDiagnostico(), dto.getComentarios());
    }

    public static ResponseRegistroDTO fromEntity(RegistroAtendimento registroAtendimento) {

        return new ResponseRegistroDTO(registroAtendimento.getId(),
                AnimalMapper.fromEntity(registroAtendimento.getAnimal()),
                MedicoMapper.fromEntity(registroAtendimento.getMedico()), registroAtendimento.getData(),
                registroAtendimento.getDadosAnimal(),
                registroAtendimento.getDiagnostico(), registroAtendimento.getComentarios());
    }

    public static List<ResponseRegistroDTO> toCollectionDTO(List<RegistroAtendimento> registro) {
        return registro.stream()
                .map(RegistroMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
