package com.dynoware.cargosafe.platform.requestService.application.internal.eventhandlers;
import com.dynoware.cargosafe.platform.requestService.domain.model.entities.Status;

import com.dynoware.cargosafe.platform.requestService.domain.model.valueobjects.StatusName;

import com.dynoware.cargosafe.platform.requestService.infrastructure.persistence.jpa.repositories.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    private final StatusRepository statusRepository;

    public DataLoader(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for (StatusName name : StatusName.values()) {
            if (statusRepository.findByName(name).isEmpty()) {
                Status status = new Status(name);
                statusRepository.savePredefined(status);
            }
        }
    }
}