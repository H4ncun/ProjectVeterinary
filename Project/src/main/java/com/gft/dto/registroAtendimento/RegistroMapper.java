package com.gft.dto.registroAtendimento;

import com.gft.dto.animal.AnimalMapper;
import com.gft.dto.medico.MedicoMapper;
import com.gft.entities.Animal;
import com.gft.entities.Medico;
import com.gft.entities.RegistroAtendimento;

import java.time.LocalDate;

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
}
