package com.gft.service;

import com.gft.entities.Medico;
import com.gft.entities.TipoUser;
import com.gft.exception.EntidadeNaoEncontradaException;
import com.gft.repositories.EnderecoRepository;
import com.gft.repositories.MedicoRepository;
import com.gft.repositories.TipoUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class MedicoService {

    private MedicoRepository medicoRepository;

    private EnderecoRepository enderecoRepository;

    private TipoUserRepository tipoUserRepository;

    public Medico buscar(Long medicoId) {
        return medicoRepository.findById(medicoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Médico não encontrado"));
    }

    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

    @Transactional
    public void salvar(Medico medico) {
        TipoUser tipo = tipoUserRepository.findByTipo("DOCTOR");
        medico.getSystemUser().setTipo(tipo);
        medicoRepository.save(medico);
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

        Medico medico = this.buscar(medicoId);

        medicoRepository.delete(medico);
    }
}
