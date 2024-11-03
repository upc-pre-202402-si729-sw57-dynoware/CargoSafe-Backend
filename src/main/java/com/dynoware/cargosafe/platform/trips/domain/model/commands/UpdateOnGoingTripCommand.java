package com.dynoware.cargosafe.platform.trips.domain.model.commands;

public record UpdateOnGoingTripCommand(
        Long id,
        Float latitude,
        Float longitude,
        Integer speed,
        Integer distance
) {
}
