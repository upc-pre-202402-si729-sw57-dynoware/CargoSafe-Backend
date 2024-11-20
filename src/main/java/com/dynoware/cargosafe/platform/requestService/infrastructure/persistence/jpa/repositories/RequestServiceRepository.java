package com.dynoware.cargosafe.platform.requestService.infrastructure.persistence.jpa.repositories;

import com.dynoware.cargosafe.platform.requestService.domain.model.aggregates.RequestService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestServiceRepository  extends JpaRepository<RequestService, Long> {
}