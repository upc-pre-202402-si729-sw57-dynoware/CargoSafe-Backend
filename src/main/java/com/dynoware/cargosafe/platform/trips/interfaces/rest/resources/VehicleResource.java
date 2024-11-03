package com.dynoware.cargosafe.platform.trips.interfaces.rest.resources;

public record VehicleResource(
        Long id,
        String model,
        String plate,
        float max_load,
        float volume,
        String photo_url
) {
}
