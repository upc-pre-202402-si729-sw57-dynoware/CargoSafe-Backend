package com.dynoware.cargosafe.platform.trips.domain.services;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.OnGoingTrip;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateOnGoingTripCommand;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.UpdateOnGoingTripCommand;

import java.util.Optional;

public interface OnGoingTripCommandService {
    Long handle(CreateOnGoingTripCommand command);
    Optional<OnGoingTrip> handle(UpdateOnGoingTripCommand command);
}
