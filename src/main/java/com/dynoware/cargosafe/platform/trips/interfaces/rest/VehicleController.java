package com.dynoware.cargosafe.platform.trips.interfaces.rest;

import com.dynoware.cargosafe.platform.trips.domain.model.commands.DeleteVehicleCommand;
import com.dynoware.cargosafe.platform.trips.domain.model.queries.GetAllVehiclesQuery;
import com.dynoware.cargosafe.platform.trips.domain.model.queries.GetVehicleByIdQuery;
import com.dynoware.cargosafe.platform.trips.domain.services.VehicleCommandService;
import com.dynoware.cargosafe.platform.trips.domain.services.VehicleQueryService;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.CreateVehicleResource;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.UpdateVehicleResource;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.VehicleResource;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.transform.CreateVehicleCommandFromResourceAssembler;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.transform.UpdateVehicleCommandFromResourceAssembler;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.transform.VehicleResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/vehicles")
@Tag(name = "Vehicles", description = "Vehicles Management Endpoints")
public class VehicleController {
    private final VehicleQueryService vehicleQueryService;
    private final VehicleCommandService vehicleCommandService;

    public VehicleController(VehicleQueryService vehicleQueryService, VehicleCommandService vehicleCommandService) {
        this.vehicleQueryService = vehicleQueryService;
        this.vehicleCommandService = vehicleCommandService;
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleResource> getVehicleById(@PathVariable Long vehicleId) {
        var getVehicleByIdQuery = new GetVehicleByIdQuery(vehicleId);
        var vehicle = vehicleQueryService.handle(getVehicleByIdQuery);
        if (vehicle.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(VehicleResourceFromEntityAssembler.transformResourceFromEntity(vehicle.get()));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResource>> getAllVehicles() {
        var getAllVehiclesQuery = new GetAllVehiclesQuery();
        var vehicles = vehicleQueryService.handle(getAllVehiclesQuery);
        var vehiclesResource = vehicles.stream().map(VehicleResourceFromEntityAssembler::transformResourceFromEntity).toList();
        return ResponseEntity.ok(vehiclesResource);
    }

    @PostMapping
    public ResponseEntity<VehicleResource> createVehicle(@RequestBody CreateVehicleResource resource) {
        var createVehicleCommand = CreateVehicleCommandFromResourceAssembler.toCommandFromResource(resource);
        var vehicle = vehicleCommandService.handle(createVehicleCommand);
        if (vehicle.isEmpty()) return ResponseEntity.notFound().build();
        var vehicleResource = VehicleResourceFromEntityAssembler.transformResourceFromEntity(vehicle.get());
        return ResponseEntity.ok(vehicleResource);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<VehicleResource> updateVehicle(@PathVariable Long vehicleId, @RequestBody UpdateVehicleResource resource) {
        var updateVehicleCommand = UpdateVehicleCommandFromResourceAssembler.toCommandFromResource(vehicleId, resource);
        var updatedVehicle = vehicleCommandService.handle(updateVehicleCommand);
        if (updatedVehicle.isEmpty()) return ResponseEntity.notFound().build();
        var vehicleResource = VehicleResourceFromEntityAssembler.transformResourceFromEntity(updatedVehicle.get());
        return ResponseEntity.ok(vehicleResource);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long vehicleId) {
        var deleteVehicleCommand = new DeleteVehicleCommand(vehicleId);
        vehicleCommandService.handle(deleteVehicleCommand);
        return ResponseEntity.ok("Vehicle deleted successfully");
    }
}
