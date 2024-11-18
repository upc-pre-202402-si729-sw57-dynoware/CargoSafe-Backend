package com.dynoware.cargosafe.platform.trips.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Trip;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.UpdateTripCommand;

public class TripCommandFromEntityAssembler {
    public static UpdateTripCommand toCommandFromEntity(Trip trip) {
        return new UpdateTripCommand(
                trip.getId(),
                trip.getName(),
                trip.getType(),
                trip.getWeight(),
                trip.getUnloadDirection(),
                trip.getUnloadLocation(),
                trip.getUnloadDate(),
                trip.getExpense().getId(),
                trip.getAlert().getId(),
                trip.getOngoingTrip().getId(),
                trip.getVehicle().getId(),
                trip.getDriver().getId(),
                trip.getUser().getId(),
                trip.getDestination(),
                trip.getDepartment(),
                trip.getDistrict(),
                trip.getCountry(),
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