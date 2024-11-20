package com.dynoware.cargosafe.platform.trips.domain.services;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Vehicle;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateVehicleCommand;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.DeleteVehicleCommand;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.UpdateVehicleCommand;

import java.util.Optional;

public interface VehicleCommandService {
    void createVehicle(CreateVehicleCommand command);
    void updateVehicle(UpdateVehicleCommand command);
    void deleteVehicle(DeleteVehicleCommand command);
    void handle(CreateVehicleCommand command);
}