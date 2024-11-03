package com.dynoware.cargosafe.platform.trips.domain.model.queries;

public record GetAlertByIdQuery(Long id) {
    public GetAlertByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }
}
