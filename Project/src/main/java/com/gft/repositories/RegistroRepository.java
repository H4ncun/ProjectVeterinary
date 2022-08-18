package com.gft.repositories;

import com.gft.entities.Animal;
import com.gft.entities.RegistroAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistroRepository extends JpaRepository<RegistroAtendimento, Long> {
    List<RegistroAtendimento> findByAnimal(Animal id);
}
