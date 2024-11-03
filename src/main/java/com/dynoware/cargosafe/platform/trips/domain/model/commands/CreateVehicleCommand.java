package com.dynoware.cargosafe.platform.trips.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record CreateVehicleCommand(
        @NotBlank String model,
        @NotBlank String plate,
        @NotBlank float max_load,
        @NotBlank float volume,
        String photo_url
) {
}
