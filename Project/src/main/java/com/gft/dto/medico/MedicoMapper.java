package com.gft.dto.medico;

import com.gft.dto.EnderecoDTO.EnderecoMapper;
import com.gft.entities.Medico;

public class MedicoMapper {

	public static Medico fromDTO(RequestMedicoDTO dto) {
		
		return new Medico(null, dto.getSalario(), dto.getNome(), dto.getSobrenome(), EnderecoMapper.fromDTO(dto.getEndereco()), dto.getTelefone());
	}
	
	public static ResponseMedicoDTO fromEntity(Medico medico) {
		return new ResponseMedicoDTO(medico.getId(), medico.getSalario(), medico.getNome(), medico.getSobrenome(), EnderecoMapper.fromEntity(medico.getEndereco()), medico.getTelefone());
	}
}
