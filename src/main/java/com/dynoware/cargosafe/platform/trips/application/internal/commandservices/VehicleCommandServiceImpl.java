package com.dynoware.cargosafe.platform.trips.application.internal.commandservices;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Vehicle;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateVehicleCommand;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.DeleteVehicleCommand;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.UpdateVehicleCommand;
import com.dynoware.cargosafe.platform.trips.domain.services.VehicleCommandService;
import com.dynoware.cargosafe.platform.trips.infrastructure.persistence.jpa.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleCommandServiceImpl implements VehicleCommandService {
    private final VehicleRepository vehicleRepository;

    public VehicleCommandServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Optional<Vehicle> handle(CreateVehicleCommand command) {
        if (vehicleRepository.existsByModel(command.model())) {
            throw new IllegalArgumentException("A vehicle with that model already exists");
        }
        var vehicle = new Vehicle(command);
        try {
            vehicleRepository.save(vehicle);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while creating a new vehicle");
        }

        return Optional.of(vehicle);
    }

    @Override
    public Optional<Vehicle> handle(UpdateVehicleCommand command) {
        if (vehicleRepository.existsByModel(command.model())) {
            throw new IllegalArgumentException("A vehicle with that model already exists");
        }
        var vehicle = vehicleRepository.findById(command.id());
        if (vehicle.isEmpty()) throw new IllegalArgumentException("A vehicle with that id does not exist");
        var newVehicle = vehicle.get();
        try {
            var updatedVehicle = vehicleRepository.save(newVehicle.updateVehicle(command));
            return Optional.of(updatedVehicle);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating the vehicle");
        }
    }

    @Override
    public void handle(DeleteVehicleCommand command) {
        if (!vehicleRepository.existsById(command.id())) {
            throw new IllegalArgumentException("A vehicle with that id does not exist");
        }
        try {
            vehicleRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting the vehicle");
        }
    }
}
