package com.dynoware.cargosafe.platform.requestService.infrastructure.persistence.jpa.repositories;

import com.dynoware.cargosafe.platform.requestService.domain.model.entities.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomStatusRepositoryImpl implements CustomStatusRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public <S extends Status> S savePredefined(S entity) {
        entityManager.persist(entity);
        return entity;
    }
}