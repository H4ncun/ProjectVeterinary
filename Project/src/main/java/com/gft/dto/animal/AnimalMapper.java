package com.gft.dto.animal;


import com.gft.entities.Animal;
import com.gft.entities.Cliente;
import com.gft.entities.Raca;

import java.util.List;
import java.util.stream.Collectors;

public class AnimalMapper {

    public static Animal fromDTO(RequestAnimalDTO dto) {

        return new Animal(null, dto.getNome(), new Raca(dto.getRacaId()), dto.getDataNascimento(), new Cliente(dto.getTutorID()));

    }

    public static ResponseAnimalDTO fromEntity(Animal animal) {

        return new ResponseAnimalDTO(animal.getId(), animal.getNome(), animal.getRaca(), animal.getDataNascimento(), animal.getTutor().getId());
    }

    public static List<ResponseAnimalDTO> toCollectionDTO(List<Animal> animais) {

        return animais.stream()
                .map(AnimalMapper::fromEntity)
                .collect(Collectors.toList());
    }


}
