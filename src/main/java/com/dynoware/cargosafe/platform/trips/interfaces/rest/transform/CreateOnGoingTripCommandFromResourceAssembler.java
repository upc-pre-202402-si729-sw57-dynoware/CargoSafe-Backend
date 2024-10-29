package com.dynoware.cargosafe.platform.trips.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateOnGoingTripCommand;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.CreateOnGoingTripResource;

public class CreateOnGoingTripCommandFromResourceAssembler {
    public static CreateOnGoingTripCommand toCommandFromResource(CreateOnGoingTripResource resource) {
        return new CreateOnGoingTripCommand(
                resource.latitude(),
                resource.longitude(),
                resource.speed(),
                resource.distance()
        );
    }
}
