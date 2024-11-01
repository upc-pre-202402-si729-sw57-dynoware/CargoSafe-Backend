package com.dynoware.cargosafe.platform.trips.domain.model.commands;

public record UpdateDriverCommand(Long id, String name, String dni, String license,String contactNum) {
}
