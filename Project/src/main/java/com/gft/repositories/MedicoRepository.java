package com.gft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.entities.Medico;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
