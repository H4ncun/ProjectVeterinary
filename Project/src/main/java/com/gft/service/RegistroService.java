package com.gft.service;

import java.util.List;

import com.gft.entities.Animal;
import org.springframework.stereotype.Service;

import com.gft.entities.RegistroAtendimento;
import com.gft.repositories.RegistroRepository;

@Service
public class RegistroService {

    final RegistroRepository registroRepository;
    final MedicoService medicoService;
    final AnimalService animalService;

    public RegistroService(RegistroRepository registroRepository, MedicoService medicoService, AnimalService animalService) {
        this.registroRepository = registroRepository;
		this.medicoService = medicoService;
		this.animalService = animalService;
    }

    public void salvar(RegistroAtendimento registro) {
    	medicoService.buscar(registro.getMedico().getId());
    	animalService.buscar(registro.getAnimal().getId());
        registroRepository.save(registro);
    }

    public List<RegistroAtendimento> listar() {
        return registroRepository.findAll();
    }

    public List<RegistroAtendimento> listarPeloIDAnimal(Long id){
        return registroRepository.findByAnimal(new Animal(id));
    }

}
