package com.dynoware.cargosafe.platform.requestService.infrastructure.persistence.jpa.repositories;

import com.dynoware.cargosafe.platform.requestService.domain.model.entities.Status;
import com.dynoware.cargosafe.platform.requestService.domain.model.valueobjects.StatusName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long>, CustomStatusRepository {
    Optional<Status> findByName(StatusName name);

    @Override
    default <S extends Status> S save(S entity) {
        throw new UnsupportedOperationException("Cannot insert new Status values");
    }
}