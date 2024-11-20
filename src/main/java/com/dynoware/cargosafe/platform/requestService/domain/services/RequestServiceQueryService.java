package com.dynoware.cargosafe.platform.requestService.domain.services;

import com.dynoware.cargosafe.platform.requestService.domain.model.aggregates.RequestService;
import com.dynoware.cargosafe.platform.requestService.domain.model.queries.GetAllRequestServiceQuery;
import com.dynoware.cargosafe.platform.requestService.domain.model.queries.GetRequestServiceByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RequestServiceQueryService {
    Optional<RequestService> handle(GetRequestServiceByIdQuery query);
    List<RequestService> handle(GetAllRequestServiceQuery query);
}