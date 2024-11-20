package com.dynoware.cargosafe.platform.trips.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateTripCommand;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.CreateTripResource;

public class CreateTripCommandFromResourceAssembler {
    public static CreateTripCommand toCommandFromResource(CreateTripResource resource) {
        return new CreateTripCommand(
                resource.name(),
                resource.type(),
                resource.weight(),
                resource.unloadDirection(),
                resource.unloadLocation(),
                resource.unloadDate(),
                resource.vehicleId(),
                resource.driverId(),
                resource.numberPackages(),
                resource.holderName(),
                resource.destinationDate(),
                resource.totalAmount(),
                resource.destinationAddress(),
                resource.loadDetail(),
                resource.pickupAddress()
        );
    }
}