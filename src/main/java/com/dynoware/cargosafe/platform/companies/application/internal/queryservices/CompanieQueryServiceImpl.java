package com.dynoware.cargosafe.platform.companies.application.internal.queryservices;

import com.dynoware.cargosafe.platform.companies.domain.model.entities.Companie;
import com.dynoware.cargosafe.platform.companies.domain.model.queries.GetCompanieByIdQuery;
import com.dynoware.cargosafe.platform.companies.domain.services.CompanieQueryService;
import com.dynoware.cargosafe.platform.companies.infrastructure.persistence.jpa.repositories.CompanieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanieQueryServiceImpl implements CompanieQueryService {
    private final CompanieRepository repository;

    public CompanieQueryServiceImpl(CompanieRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Companie> handle(GetCompanieByIdQuery query) {
        return repository.findById(query.id());
    }
}
