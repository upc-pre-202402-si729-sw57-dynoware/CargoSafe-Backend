package com.dynoware.cargosafe.platform.trips.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Alert;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.AlertResource;

public class AlertResourceFromEntityAssembler {
    public static AlertResource toResourceFromEntity(Alert entity) {
        return new AlertResource(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getDate());
    }
}