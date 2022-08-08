package com.gft.service;

import com.gft.entities.Medico;
import com.gft.exception.NegocioException;
import com.gft.repositories.EnderecoRepository;
import com.gft.repositories.MedicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class MedicoService {

    private MedicoRepository medicoRepository;

    private EnderecoRepository enderecoRepository;

    public Medico buscar(Long medicoId) {
        return medicoRepository.findById(medicoId)
                .orElseThrow(() -> new NegocioException("Médico não encontrado"));
    }

    public List<Medico> listar() {

        return medicoRepository.findAll();
    }

    @Transactional
    public Medico salvar(Medico medico) {

        return medicoRepository.save(medico);
    }

    @Transactional
    public Medico atualizar(Medico medico, Long id) {
        Medico medicoOriginal = this.buscar(id);
        medico.setId(medicoOriginal.getId());
        medico.getEndereco().setId(medicoOriginal.getEndereco().getId());
        enderecoRepository.save(medico.getEndereco());
        return medicoRepository.save(medico);
    }

    @Transactional
    public void excluir(Long medicoId) {

        medicoRepository.deleteById(medicoId);
    }
}
