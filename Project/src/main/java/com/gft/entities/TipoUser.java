package com.gft.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TipoUser implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    public TipoUser(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getAuthority() {
        return getTipo();
    }


    @Override
    public String toString() {
        return "Perfil [id=" + id + ", tipo=" + tipo + "]";
    }

}
