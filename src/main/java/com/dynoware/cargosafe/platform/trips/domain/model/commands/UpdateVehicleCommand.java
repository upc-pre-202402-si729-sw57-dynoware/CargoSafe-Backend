package com.dynoware.cargosafe.platform.trips.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record UpdateVehicleCommand(
        Long id,
        String model,
        String plate,
        float maxLoad,
        float volume,
        String photoUrl
) {
}
