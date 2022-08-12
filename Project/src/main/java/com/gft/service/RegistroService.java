package com.gft.service;

import com.gft.entities.RegistroAtendimento;
import com.gft.repositories.RegistroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {

    final RegistroRepository registroRepository;

    public RegistroService(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    public RegistroAtendimento salvar(RegistroAtendimento registro) {

        return registroRepository.save(registro);
    }

    public List<RegistroAtendimento> listar() {
        return registroRepository.findAll();
    }

}
