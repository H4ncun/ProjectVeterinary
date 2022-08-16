package com.gft.dto.medico;

import com.gft.dto.enderecoDTO.EnderecoMapper;
import com.gft.entities.Medico;
import com.gft.formatting.Format;

public class MedicoMapper {

    public static Medico fromDTO(RequestMedicoDTO dto) {

        return new Medico(null, dto.getSalario(), dto.getNome(), EnderecoMapper.fromDTO(dto.getEndereco()),
                new Format().formatNumberPhone(dto.getTelefone()));
    }

    public static ResponseMedicoDTO fromEntity(Medico medico) {
        return new ResponseMedicoDTO(medico.getId(), medico.getNome(),medico.getSalario(), medico.getTelefone(), EnderecoMapper.fromEntity(medico.getEndereco()));
    }
}
