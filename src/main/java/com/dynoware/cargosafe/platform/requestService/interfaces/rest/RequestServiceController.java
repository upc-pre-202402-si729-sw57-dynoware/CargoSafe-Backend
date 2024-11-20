package com.dynoware.cargosafe.platform.requestService.interfaces.rest;

import com.dynoware.cargosafe.platform.requestService.application.internal.commandservices.RequestServiceCommandServiceImpl;
import com.dynoware.cargosafe.platform.requestService.application.internal.queryservices.RequestServiceQueryServiceImpl;
import com.dynoware.cargosafe.platform.requestService.application.internal.queryservices.StatusQueryServiceImpl;
import com.dynoware.cargosafe.platform.requestService.domain.model.aggregates.RequestService;
import com.dynoware.cargosafe.platform.requestService.domain.model.commands.DeleteRequestServiceCommand;
import com.dynoware.cargosafe.platform.requestService.domain.model.commands.UpdateRequestServiceCommand;
import com.dynoware.cargosafe.platform.requestService.domain.model.entities.Status;
import com.dynoware.cargosafe.platform.requestService.domain.model.queries.GetAllRequestServiceQuery;
import com.dynoware.cargosafe.platform.requestService.domain.model.queries.GetRequestServiceByIdQuery;
import com.dynoware.cargosafe.platform.requestService.interfaces.rest.resources.CreateRequestServiceResource;
import com.dynoware.cargosafe.platform.requestService.interfaces.rest.resources.RequestServiceResource;
import com.dynoware.cargosafe.platform.requestService.interfaces.rest.resources.UpdateRequestServiceStatusResource;
import com.dynoware.cargosafe.platform.requestService.interfaces.rest.transform.CreateRequestServiceCommandFromResourceAssembler;
import com.dynoware.cargosafe.platform.requestService.interfaces.rest.transform.RequestServiceResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Request Service", description = "Trip Request service Endpoints")
@RequestMapping("/api/v1/requestServices")
public class RequestServiceController {
    private final RequestServiceCommandServiceImpl commandService;
    private final RequestServiceQueryServiceImpl queryService;
    private final StatusQueryServiceImpl statusQueryService;

    public RequestServiceController(RequestServiceCommandServiceImpl commandService, RequestServiceQueryServiceImpl queryService, StatusQueryServiceImpl statusQueryService) {
        this.commandService = commandService;
        this.queryService = queryService;
        this.statusQueryService = statusQueryService;
    }

    @PostMapping
    public ResponseEntity<RequestServiceResource> createRequestService(@RequestBody CreateRequestServiceResource resource) {
        var command = CreateRequestServiceCommandFromResourceAssembler.toCommandFromResource(resource);
        var createdRequestService = commandService.handle(command);
        var requestServiceResource = RequestServiceResourceFromEntityAssembler.transformResourceFromEntity(createdRequestService);
        return ResponseEntity.ok(requestServiceResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestServiceResource> updateRequestService(@PathVariable Long id, @RequestBody CreateRequestServiceResource resource) {
        var command = new UpdateRequestServiceCommand(id,
                resource.unloadDirection(),
                resource.type(),
                resource.numberPackages(),
                resource.country(),
                resource.department(),
                resource.district(),
                resource.destination(),
                resource.unloadLocation(),
                resource.unloadDate(),
                resource.distance(),
                resource.statusId(),
                resource.holderName(),
                resource.pickupAddress(),
                resource.pickupLat(),
                resource.pickupLng(),
                resource.destinationAddress(),
                resource.destinationLat(),
                resource.destinationLng(),
                resource.loadDetail(),
                resource.weight()
        );
        var updatedRequestService = commandService.handle(command);
        var requestServiceResource = RequestServiceResourceFromEntityAssembler.transformResourceFromEntity(updatedRequestService);
        return ResponseEntity.ok(requestServiceResource);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<RequestServiceResource> updateRequestServiceStatus(@PathVariable Long id, @RequestBody UpdateRequestServiceStatusResource resource) {
        var requestService = queryService.handle(new GetRequestServiceByIdQuery(id))
                .orElseThrow(() -> new IllegalArgumentException("RequestService not found"));
        var updatedRequestService = commandService.updateStatus(requestService, resource.statusId());
        var requestServiceResource = RequestServiceResourceFromEntityAssembler.transformResourceFromEntity(updatedRequestService);
        return ResponseEntity.ok(requestServiceResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestServiceResource> getRequestServiceById(@PathVariable Long id) {
        var requestService = queryService.handle(new GetRequestServiceByIdQuery(id))
                .orElseThrow(() -> new IllegalArgumentException("RequestService not found"));
        var requestServiceResource = RequestServiceResourceFromEntityAssembler.transformResourceFromEntity(requestService);
        return ResponseEntity.ok(requestServiceResource);
    }

    @GetMapping
    public ResponseEntity<List<RequestServiceResource>> getAllRequestServices() {
        var requestServices = queryService.handle(new GetAllRequestServiceQuery());
        var requestServiceResources = requestServices.stream()
                .map(RequestServiceResourceFromEntityAssembler::transformResourceFromEntity)
                .toList();
        return ResponseEntity.ok(requestServiceResources);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Status>> getAllStatuses() {
        var statuses = statusQueryService.handle();
        return ResponseEntity.ok(statuses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequestService(@PathVariable Long id) {
        var command = new DeleteRequestServiceCommand(id);
        commandService.handle(command);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/assignVehicle")
    public ResponseEntity<RequestServiceResource> assignVehicle(@PathVariable Long id, @RequestBody Long vehicleId) {
        var requestService = queryService.handle(new GetRequestServiceByIdQuery(id))
                .orElseThrow(() -> new IllegalArgumentException("RequestService not found"));
        var updatedRequestService = commandService.assignVehicle(requestService, vehicleId);
        var requestServiceResource = RequestServiceResourceFromEntityAssembler.transformResourceFromEntity(updatedRequestService);
        return ResponseEntity.ok(requestServiceResource);
    }

    @PutMapping("/{id}/assignDriver")
    public ResponseEntity<RequestServiceResource> assignDriver(@PathVariable Long id, @RequestBody Long driverId) {
        var requestService = queryService.handle(new GetRequestServiceByIdQuery(id))
                .orElseThrow(() -> new IllegalArgumentException("RequestService not found"));
        var updatedRequestService = commandService.assignDriver(requestService, driverId);
        var requestServiceResource = RequestServiceResourceFromEntityAssembler.transformResourceFromEntity(updatedRequestService);
        return ResponseEntity.ok(requestServiceResource);
    }
}