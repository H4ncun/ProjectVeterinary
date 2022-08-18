package com.gft.dto.medicoDTO;

import com.gft.dto.enderecoDTO.EnderecoMapper;
import com.gft.entities.Medico;
import com.gft.entities.SystemUser;
import com.gft.formatting.Format;

public class MedicoMapper {

    public static Medico fromDTO(RequestMedicoDTO dto) {

        return new Medico(null, dto.getSalario(), dto.getNome(), EnderecoMapper.fromDTO(dto.getEndereco()),
                new Format().formatNumberPhone(dto.getTelefone()),new SystemUser());
    }

    public static ResponseMedicoDTO fromEntity(Medico medico) {
        return new ResponseMedicoDTO(medico.getId(), medico.getNome(),medico.getSalario(),medico.getSystemUser().getEmail(),
                medico.getTelefone(), EnderecoMapper.fromEntity(medico.getEndereco()));
    }
}
