package com.dynoware.cargosafe.platform.companies.domain.model.commands;

public record CreateCompanieCommand(String companieName) {
    public CreateCompanieCommand {
        if (companieName == null || companieName.isBlank()) {
            throw new IllegalArgumentException("The companie name cannot be empty");
        }
    }
}
