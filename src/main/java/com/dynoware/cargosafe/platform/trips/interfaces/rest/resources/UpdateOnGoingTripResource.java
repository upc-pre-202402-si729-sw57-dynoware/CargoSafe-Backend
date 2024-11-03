package com.dynoware.cargosafe.platform.trips.interfaces.rest.resources;

public record UpdateOnGoingTripResource(
        Float latitude,
        Float longitude,
        Integer speed,
        Integer distance
) {
}
