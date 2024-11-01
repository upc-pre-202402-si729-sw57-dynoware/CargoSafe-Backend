package com.dynoware.cargosafe.platform.trips.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.trips.domain.model.commands.UpdateVehicleCommand;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.UpdateVehicleResource;

public class UpdateVehicleCommandFromResourceAssembler {
    public static UpdateVehicleCommand toCommandFromResource(long id, UpdateVehicleResource resource) {
        return new UpdateVehicleCommand(
                id,
                resource.model(),
                resource.plate(),
                resource.max_load(),
                resource.volume(),
                resource.photo_url()
        );
    }
}
