package com.dynoware.cargosafe.platform.companies.interfaces.rest.resources;

public record CreateCompanieResource(String companieName) {
    public CreateCompanieResource {
        if (companieName == null || companieName.isBlank()) {
            throw new IllegalArgumentException("The companie name cannot be empty");
        }
    }
}
