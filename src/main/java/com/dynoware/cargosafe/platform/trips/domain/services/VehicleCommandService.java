package com.dynoware.cargosafe.platform.trips.domain.services;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Vehicle;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateVehicleCommand;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.DeleteVehicleCommand;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.UpdateVehicleCommand;

import java.util.Optional;

public interface VehicleCommandService {
    Optional<Vehicle> handle (CreateVehicleCommand command);
    Optional<Vehicle> handle (UpdateVehicleCommand command);
    void handle (DeleteVehicleCommand command);
}
