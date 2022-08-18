package com.gft.repositories;

import com.gft.entities.Animal;
import com.gft.entities.Cliente;
import com.gft.entities.RegistroAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.Raca;

import java.util.List;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Long> {
}
