package com.gft.repositories;

import com.gft.entities.TipoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUserRepository extends JpaRepository<TipoUser, Long> {
    TipoUser findByTipo(String tipo);
}
