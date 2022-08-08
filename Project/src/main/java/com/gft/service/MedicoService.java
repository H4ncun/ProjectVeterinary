package com.gft.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gft.entities.Medico;
import com.gft.exception.NegocioException;
import com.gft.repositories.MedicoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MedicoService {

	private MedicoRepository medicoRepository;
	
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
		return medicoRepository.save(medico);
	}
	
	
	@Transactional
	public void excluir(Long medicoId) {
		medicoRepository.deleteById(medicoId);
	}
}
