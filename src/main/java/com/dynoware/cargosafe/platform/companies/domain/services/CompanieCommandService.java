package com.dynoware.cargosafe.platform.companies.domain.services;

import com.dynoware.cargosafe.platform.companies.domain.model.commands.CreateCompanieCommand;
import com.dynoware.cargosafe.platform.companies.domain.model.commands.DeleteCompanieCommand;

public interface CompanieCommandService {
    void handle(CreateCompanieCommand command);
    void handle(DeleteCompanieCommand command);
}
