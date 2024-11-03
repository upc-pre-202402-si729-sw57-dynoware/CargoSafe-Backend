package com.dynoware.cargosafe.platform.trips.interfaces.rest.resources;

public record CreateExpenseResource(int fuel_amount, String fuel_description, int viatics_amount, String viatics_description, int tolls_amount, String tolls_description) {
    public CreateExpenseResource {
        if (fuel_amount <= 0) {
            throw new IllegalArgumentException("Fuel amount must be greater than 0");
        }
        if (fuel_description == null || fuel_description.isBlank()) {
            throw new IllegalArgumentException("Fuel description cannot be null or empty");
        }
        if (viatics_amount <= 0) {
            throw new IllegalArgumentException("Viatics amount must be greater than 0");
        }
        if (viatics_description == null || viatics_description.isBlank()) {
            throw new IllegalArgumentException("Viatics description cannot be null or empty");
        }
        if (tolls_amount <= 0) {
            throw new IllegalArgumentException("Tolls amount must be greater than 0");
        }
        if (tolls_description == null || tolls_description.isBlank()) {
            throw new IllegalArgumentException("Tolls description cannot be null or empty");
        }
    }
}
