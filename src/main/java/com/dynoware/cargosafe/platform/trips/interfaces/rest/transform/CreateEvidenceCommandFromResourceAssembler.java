package com.dynoware.cargosafe.platform.trips.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateEvidenceCommand;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.CreateEvidenceResource;

public class CreateEvidenceCommandFromResourceAssembler {
    public static CreateEvidenceCommand toCommandFromResource(CreateEvidenceResource resource){
        return new CreateEvidenceCommand(
                resource.link(),
                resource.trip_id()
        );
    }
}
