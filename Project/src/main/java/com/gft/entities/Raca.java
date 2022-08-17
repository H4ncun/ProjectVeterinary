package com.gft.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Raca {

	@Id
	private Long id;
	private String name;
	
	public Raca(Long id) {
		this.id = id;
	}
	
	

}
