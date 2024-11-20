package com.dynoware.cargosafe.platform.trips.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Trip;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.UpdateTripCommand;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.TripResource;

public class TripResourceFromEntityAssembler {
    public static TripResource toResourceFromEntity(Trip trip) {
        return new TripResource(
                trip.getId(),
                trip.getName(),
                trip.getType(),
                trip.getWeight(),
                trip.getUnloadDirection(),
                trip.getUnloadLocation(),
                trip.getUnloadDate(),
                trip.getVehicle(),
                trip.getDriver(),
                trip.getNumberPackages(),
                trip.getHolderName(),
                trip.getDestinationDate(),
                trip.getTotalAmount(),
                trip.getDestinationAddress(),
                trip.getLoadDetail(),
                trip.getPickupAddress()
        );
    }
}