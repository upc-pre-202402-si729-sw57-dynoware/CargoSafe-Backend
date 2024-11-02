package com.dynoware.cargosafe.platform.companies.infrastructure.persistence.jpa.repositories;

import com.dynoware.cargosafe.platform.companies.domain.model.entities.Companie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanieRepository extends JpaRepository<Companie, Long> {
    Optional<Companie> findById(Long id);
}
