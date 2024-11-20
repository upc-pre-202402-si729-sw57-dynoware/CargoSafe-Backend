package com.dynoware.cargosafe.platform.trips.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.trips.domain.model.commands.UpdateVehicleCommand;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.UpdateVehicleResource;

public class UpdateVehicleCommandFromResourceAssembler {
    public static UpdateVehicleCommand toCommandFromResource(Long vehicleId, UpdateVehicleResource resource) {
        return new UpdateVehicleCommand(
                vehicleId,
                resource.model(),
                resource.plate(),
                resource.maxLoad(),
                resource.volume(),
                resource.photoUrl()
        );
    }
}