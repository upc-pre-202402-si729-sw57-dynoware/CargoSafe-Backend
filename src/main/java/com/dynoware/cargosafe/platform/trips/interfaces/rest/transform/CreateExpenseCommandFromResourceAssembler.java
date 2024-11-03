package com.dynoware.cargosafe.platform.trips.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateExpenseCommand;
import com.dynoware.cargosafe.platform.trips.interfaces.rest.resources.CreateExpenseResource;

public class CreateExpenseCommandFromResourceAssembler {
    public static CreateExpenseCommand toCommandFromResource(CreateExpenseResource resource) {
        return new CreateExpenseCommand(resource.fuel_amount(), resource.fuel_description(), resource.viatics_amount(), resource.viatics_description(), resource.tolls_amount(), resource.tolls_description());
    }
}