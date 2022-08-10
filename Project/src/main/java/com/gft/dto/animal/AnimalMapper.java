package com.gft.dto.animal;


import com.gft.entities.Animal;
import com.gft.entities.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalMapper {


    public static Animal fromDTO(RequestAnimalDTO dto) {

        return new Animal(null, dto.getNome(), dto.getRaca(), LocalDate.now(), new Cliente(dto.getTutorID()));

    }

    public static ResponseAnimalDTO fromEntity(Animal animal) {

        return new ResponseAnimalDTO(animal.getId(), animal.getNome(), animal.getRaca(), animal.getDataNascimento(), animal.getTutor().getId(), animal.getRegistroAtendimentos());
    }
    
    public static List<ResponseAnimalDTO> toCollectionDTO(List<Animal> animais) {
    	
    	if(animais == null) {
    		List<ResponseAnimalDTO> animal = new ArrayList<>();
    		return animal;
    	}
    	
    	return animais.stream()
    			.map(AnimalMapper::fromEntity)
    			.collect(Collectors.toList());
    }


}
