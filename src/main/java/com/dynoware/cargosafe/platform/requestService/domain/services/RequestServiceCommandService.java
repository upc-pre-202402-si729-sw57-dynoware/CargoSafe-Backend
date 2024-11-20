package com.dynoware.cargosafe.platform.requestService.domain.services;

import com.dynoware.cargosafe.platform.requestService.domain.model.aggregates.RequestService;
import com.dynoware.cargosafe.platform.requestService.domain.model.commands.CreateRequestServiceCommand;
import com.dynoware.cargosafe.platform.requestService.domain.model.commands.DeleteRequestServiceCommand;
import com.dynoware.cargosafe.platform.requestService.domain.model.commands.UpdateRequestServiceCommand;

public interface RequestServiceCommandService {
    RequestService handle(CreateRequestServiceCommand command);
    RequestService handle(UpdateRequestServiceCommand command);
    void handle(DeleteRequestServiceCommand command);
}