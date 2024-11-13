package com.dynoware.cargosafe.platform.iam.application.internal.commandservices;

import com.dynoware.cargosafe.platform.iam.domain.model.commands.SeedRolesCommand;
import com.dynoware.cargosafe.platform.iam.domain.model.entities.Role;
import com.dynoware.cargosafe.platform.iam.domain.model.valueobjects.Roles;
import com.dynoware.cargosafe.platform.iam.domain.services.RoleCommandService;
import com.dynoware.cargosafe.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * The type Role command service.
 */
@Service
public class RoleCommandServiceImpl implements RoleCommandService {
    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // inherit javadoc
    @Override
    public void handle(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if (!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        });
    }
}
