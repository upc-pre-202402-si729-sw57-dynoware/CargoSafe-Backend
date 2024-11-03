package com.dynoware.cargosafe.platform.trips.domain.services;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Alert;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateAlertCommand;

import java.util.Optional;

public interface AlertCommandService {

    Optional<Alert> handle(CreateAlertCommand command);
}
