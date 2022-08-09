package com.gft.dto.animal;


import com.gft.entities.Animal;
import com.gft.entities.Cliente;

import java.time.LocalDate;

public class AnimalMapper {


    public static Animal fromDTO(RequestAnimalDTO dto) {

//        Cliente cliente = new Cliente();
//        cliente.setId(dto.getTutorID());


        return new Animal(null, dto.getNome(), dto.getRaca(), LocalDate.now(), new Cliente(dto.getTutorID()));

    }

    public static ResponseAnimalDTO fromEntity(Animal animal) {

        return new ResponseAnimalDTO(animal.getId(), animal.getNome(), animal.getRaca(), animal.getDataNascimento(), animal.getTutor().getId(), animal.getRegistroAtendimentos());
    }


}
