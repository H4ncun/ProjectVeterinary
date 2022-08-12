package com.gft.repositories;

import com.gft.entities.RegistroAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<RegistroAtendimento, Long> {
}
