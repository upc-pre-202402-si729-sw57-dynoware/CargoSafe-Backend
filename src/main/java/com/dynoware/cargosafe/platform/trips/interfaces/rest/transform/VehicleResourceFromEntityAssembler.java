package com.dynoware.cargosafe.platform.trips.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Vehicle;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.VehicleResource;

public class VehicleResourceFromEntityAssembler {
    public static VehicleResource transformResourceFromEntity(Vehicle entity) {
        return new VehicleResource(
                entity.getId(),
                entity.getModel(),
                entity.getPlate(),
                entity.getVolume(),
                entity.getMax_load(),
                entity.getPhoto_url()
        );
    }
}
