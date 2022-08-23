package com.gft.service;

import com.gft.entities.Animal;
import com.gft.entities.RegistroAtendimento;
import com.gft.repositories.RegistroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<RegistroAtendimento> listaRegistroAnimalDoCliente(Long idCliente, Long idAnimal) {
        List<Animal> animal = animalService.listarPorClienteID(idCliente);
        for (Animal value : animal) {
            if (value.getId().equals(idAnimal)) {
                return registroRepository.findByAnimal(new Animal(idAnimal));
            }
        }
        return new ArrayList<>();
    }
}
