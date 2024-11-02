package com.dynoware.cargosafe.platform.companies.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.companies.domain.model.commands.CreateCompanieCommand;
import com.dynoware.cargosafe.platform.companies.interfaces.rest.resources.CreateCompanieResource;

public class CreateCompanieCommandFromResourceAssembler {
    public static CreateCompanieCommand toCommandFromResource(CreateCompanieResource resource) {
        return new CreateCompanieCommand(resource.companieName());
    }
}
