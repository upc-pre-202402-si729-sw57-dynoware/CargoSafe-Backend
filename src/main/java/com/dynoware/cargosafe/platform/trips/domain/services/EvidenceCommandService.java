package com.dynoware.cargosafe.platform.trips.domain.services;

import com.dynoware.cargosafe.platform.trips.domain.model.aggregates.Evidence;
import com.dynoware.cargosafe.platform.trips.domain.model.commands.CreateEvidenceCommand;

import java.util.Optional;

public interface EvidenceCommandService {
    Optional<Evidence> handle (CreateEvidenceCommand command);
}
