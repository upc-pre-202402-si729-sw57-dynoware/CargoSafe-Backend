package com.dynoware.cargosafe.platform.requestService.infrastructure.persistence.jpa.repositories;

import com.dynoware.cargosafe.platform.requestService.domain.model.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}