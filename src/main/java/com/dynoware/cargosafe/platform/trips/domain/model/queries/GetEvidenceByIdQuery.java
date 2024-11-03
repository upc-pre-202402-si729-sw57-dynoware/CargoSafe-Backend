package com.dynoware.cargosafe.platform.trips.domain.model.queries;

public record GetEvidenceByIdQuery(Long id) {
    public GetEvidenceByIdQuery {
        if (id == null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if (id < 0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
