package com.dynoware.cargosafe.platform.trips.domain.model.commands;

public record CreateExpenseCommand(int fuel_amount, String fuel_description, int viatics_amount, String viatics_description, int tolls_amount, String tolls_description) {
    public CreateExpenseCommand {
        if (fuel_amount < 0 || viatics_amount < 0 || tolls_amount < 0)
            throw new IllegalArgumentException("amounts cannot be negative");
        if (fuel_description == null || fuel_description.isBlank())
            throw new IllegalArgumentException("fuel_description cannot be null or empty");
        if (viatics_description == null || viatics_description.isBlank())
            throw new IllegalArgumentException("viatics_description cannot be null or empty");
        if (tolls_description == null || tolls_description.isBlank())
            throw new IllegalArgumentException("tolls_description cannot be null or empty");
    }

}
