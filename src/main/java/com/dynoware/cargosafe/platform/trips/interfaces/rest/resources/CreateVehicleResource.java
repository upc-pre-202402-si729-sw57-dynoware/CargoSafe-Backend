package com.dynoware.cargosafe.platform.trips.interfaces.rest.resources;

public record CreateVehicleResource(
        String model,
        String plate,
        float maxLoad,
        float volume,
        String photoUrl
) {
}
