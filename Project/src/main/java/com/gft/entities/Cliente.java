package com.gft.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "tutor",cascade = CascadeType.PERSIST)
    private List<Animal> animais;

    public Cliente(Long id, String nome, Endereco endereco, int telefone) {
        super(nome, endereco, telefone);
    }

	public Cliente(Long id) {
		this.id = id;
	}
    
    
}
