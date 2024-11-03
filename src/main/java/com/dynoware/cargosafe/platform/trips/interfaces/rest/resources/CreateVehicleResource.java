package com.dynoware.cargosafe.platform.trips.interfaces.rest.resources;

public record CreateVehicleResource(
        String model,
        String plate,
        float max_load,
        float volume,
        String photo_url
) {
}
