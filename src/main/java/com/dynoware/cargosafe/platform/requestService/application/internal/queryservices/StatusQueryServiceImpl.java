package com.dynoware.cargosafe.platform.requestService.application.internal.queryservices;

import com.dynoware.cargosafe.platform.requestService.domain.model.entities.Status;
import com.dynoware.cargosafe.platform.requestService.infrastructure.persistence.jpa.repositories.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusQueryServiceImpl {
    private final StatusRepository statusRepository;

    public StatusQueryServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> handle() {
        return statusRepository.findAll();
    }


}