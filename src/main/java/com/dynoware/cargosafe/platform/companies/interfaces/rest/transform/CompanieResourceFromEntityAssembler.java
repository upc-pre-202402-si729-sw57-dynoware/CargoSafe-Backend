package com.dynoware.cargosafe.platform.companies.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.companies.domain.model.entities.Companie;
import com.dynoware.cargosafe.platform.companies.interfaces.rest.resources.CompanieResource;

public class CompanieResourceFromEntityAssembler {
    public static CompanieResource toResourceFromEntity(Companie entity) {
        return new CompanieResource(entity.getId(), entity.getCompanieName());
    }
}