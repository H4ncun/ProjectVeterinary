package com.gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.Animal;
import com.gft.entities.Cliente;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
	List<Animal> findByTutor(Cliente id);
}
