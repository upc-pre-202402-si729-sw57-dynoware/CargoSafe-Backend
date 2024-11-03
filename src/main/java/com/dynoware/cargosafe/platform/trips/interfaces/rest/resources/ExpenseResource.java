package com.dynoware.cargosafe.platform.trips.interfaces.rest.resources;

public record ExpenseResource(Long id, int fuel_amount, String fuel_description, int viatics_amount, String viatics_description, int tolls_amount, String tolls_description) {
}
