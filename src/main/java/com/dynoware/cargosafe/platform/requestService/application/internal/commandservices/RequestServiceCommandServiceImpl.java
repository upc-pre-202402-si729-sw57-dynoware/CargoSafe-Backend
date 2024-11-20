package com.dynoware.cargosafe.platform.requestService.application.internal.commandservices;

import com.dynoware.cargosafe.platform.requestService.domain.model.aggregates.RequestService;
import com.dynoware.cargosafe.platform.requestService.domain.model.commands.CreateRequestServiceCommand;
import com.dynoware.cargosafe.platform.requestService.domain.model.commands.DeleteRequestServiceCommand;
import com.dynoware.cargosafe.platform.requestService.domain.model.commands.UpdateRequestServiceCommand;
import com.dynoware.cargosafe.platform.requestService.domain.model.entities.RequestServiceStatus;
import com.dynoware.cargosafe.platform.requestService.domain.model.entities.Status;
import com.dynoware.cargosafe.platform.requestService.domain.model.queries.GetAllRequestServiceQuery;
import com.dynoware.cargosafe.platform.requestService.domain.model.queries.GetRequestServiceByIdQuery;
import com.dynoware.cargosafe.platform.requestService.domain.model.valueobjects.StatusName;
import com.dynoware.cargosafe.platform.requestService.domain.services.RequestServiceCommandService;
import com.dynoware.cargosafe.platform.requestService.infrastructure.persistence.jpa.repositories.RequestServiceRepository;
import com.dynoware.cargosafe.platform.requestService.infrastructure.persistence.jpa.repositories.StatusRepository;
import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.*;
import com.dynoware.cargosafe.platform.trips.infrastructure.persistence.jpa.DriverRepository;
import com.dynoware.cargosafe.platform.trips.infrastructure.persistence.jpa.repositories.TripRepository;
import com.dynoware.cargosafe.platform.trips.infrastructure.persistence.jpa.repositories.VehicleRepository;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.VehicleResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceCommandServiceImpl implements RequestServiceCommandService {
    private final RequestServiceRepository repository;
    private final StatusRepository statusRepository;
    private final TripRepository tripRepository;
    private final DriverRepository driverRepository;
    private final VehicleRepository  vehicleRepository;


    public RequestServiceCommandServiceImpl(RequestServiceRepository repository, StatusRepository statusRepository, TripRepository tripRepository,DriverRepository driverRepository,VehicleRepository vehicleRepository) {
        this.repository = repository;
        this.statusRepository = statusRepository;
        this.tripRepository = tripRepository;
        this.driverRepository = driverRepository;
        this.vehicleRepository  = vehicleRepository;
    }

    @Override
    public RequestService handle(CreateRequestServiceCommand command) {
        var requestService = new RequestService();
        requestService.setUnloadDirection(command.unloadDirection());
        requestService.setType(command.type());
        requestService.setNumberPackages(command.numberPackages());
        requestService.setCountry(command.country());
        requestService.setDepartment(command.department());
        requestService.setDistrict(command.district());
        requestService.setDestination(command.destination());
        requestService.setUnloadLocation(command.unloadLocation());
        requestService.setUnloadDate(command.unloadDate());
        requestService.setDistance(command.distance());
        requestService.setHolderName(command.holderName());
        requestService.setPickupAddress(command.pickupAddress());
        requestService.setPickupLat(command.pickupLat());
        requestService.setPickupLng(command.pickupLng());
        requestService.setDestinationAddress(command.destinationAddress());
        requestService.setDestinationLat(command.destinationLat());
        requestService.setDestinationLng(command.destinationLng());
        requestService.setLoadDetail(command.loadDetail());
        requestService.setWeight(command.weight());

        Long statusId = command.statusId() != null ? command.statusId() : 3L;
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new IllegalArgumentException("Status not found"));
        requestService.setStatus(status);

        RequestServiceStatus requestServiceStatus = new RequestServiceStatus();
        requestServiceStatus.setRequestService(requestService);
        requestServiceStatus.setStatus(status);
        requestService.getStatuses().add(requestServiceStatus);

        repository.save(requestService);
        return requestService;
    }

    @Override
    public RequestService handle(UpdateRequestServiceCommand command) {
        var requestService = repository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("RequestService not found"));

        Status status = statusRepository.findById(command.statusId())
                .orElseThrow(() -> new IllegalArgumentException("Status not found"));
        requestService.setStatus(status);
        repository.save(requestService);
        return requestService;
    }

    @Override
    public void handle(DeleteRequestServiceCommand command) {
        repository.deleteById(command.id());
    }

    public RequestService updateStatus(RequestService requestService, Long statusId) {
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new IllegalArgumentException("Status not found"));
        requestService.setStatus(status);

        for (RequestServiceStatus requestServiceStatus : requestService.getStatuses()) {
            requestServiceStatus.setStatus(status);
        }

        repository.save(requestService);

        if (status.getName() == StatusName.Accepted) {
            Trip trip = new Trip();
            trip.setName("Accepted");
            trip.setType(requestService.getType());
            trip.setWeight(requestService.getWeight());
            trip.setUnloadDirection(requestService.getUnloadDirection());
            trip.setUnloadLocation(requestService.getUnloadLocation());
            trip.setUnloadDate(requestService.getUnloadDate());
            trip.setNumberPackages(requestService.getNumberPackages());
            trip.setHolderName(requestService.getHolderName());
            trip.setDestinationAddress(requestService.getDestinationAddress());
            trip.setLoadDetail(requestService.getLoadDetail());
            trip.setPickupAddress(requestService.getPickupAddress());
            trip.setDestinationDate("2024-11-21");
            trip.setTotalAmount(0.0);


            trip.setVehicle(null);
            trip.setDriver(null);

            tripRepository.save(trip);
        }

        return requestService;
    }

    public RequestService assignVehicle(RequestService requestService, Long vehicleId) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if (vehicle.isEmpty()) {
            throw new IllegalArgumentException("Vehículo no encontrado con id: " + vehicleId);
        }

        repository.save(requestService);
        return requestService;
    }

    public RequestService assignDriver(RequestService requestService, Long driverId) {
        Optional<Driver> driver = driverRepository.findById(driverId);
        if (driver.isEmpty()) {
            throw new IllegalArgumentException("Conductor no encontrado con id: " + driverId);
        }

        return requestService;
    }
}