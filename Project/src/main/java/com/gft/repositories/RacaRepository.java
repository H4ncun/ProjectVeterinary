package com.gft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.Raca;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Long> {

}
