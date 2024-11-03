package com.dynoware.cargosafe.platform.trips.domain.exceptions;

public class DriverNotFoundException extends RuntimeException {
    public DriverNotFoundException(Long aLong) {

        super("Driver with id " + aLong + "not found");
    }
}
