package com.dynoware.cargosafe.platform.requestService.domain.model.commands;

public record UpdateRequestServiceCommand(
        Long id,
        String unloadDirection,
        String type,
        int numberPackages,
        String country,
        String department,
        String district,
        String destination,
        String unloadLocation,
        String unloadDate,
        Double distance,
        Long statusId,
        String holderName,
        String pickupAddress,
        double pickupLat,
        double pickupLng,
        String destinationAddress,
        double destinationLat,
        double destinationLng,
        String loadDetail,
        double weight
) {
}