package com.dynoware.cargosafe.platform.trips.interfaces.rest.resources;

public record UpdateVehicleResource(

        String model,
        String plate,
        float maxLoad,
        float volume,
        String photoUrl
) {
}
