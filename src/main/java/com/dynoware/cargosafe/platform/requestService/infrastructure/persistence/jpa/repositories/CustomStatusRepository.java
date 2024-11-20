package com.dynoware.cargosafe.platform.requestService.infrastructure.persistence.jpa.repositories;

import com.dynoware.cargosafe.platform.requestService.domain.model.entities.Status;

public interface CustomStatusRepository {
    <S extends Status> S savePredefined(S entity);
}