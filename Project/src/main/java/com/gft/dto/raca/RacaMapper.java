package com.gft.dto.raca;

import com.gft.entities.Raca;

public class RacaMapper {

	public static Raca fromDTO(RequestRacaDTO dto) {
		return new Raca (null, dto.getName());
	}
	
	public static ResponseRacaDTO fromEntity(Raca raca) {
		return new ResponseRacaDTO(raca.getId(), raca.getName());
	}
}
