package com.dynoware.cargosafe.platform.iam.domain.services;

import com.dynoware.cargosafe.platform.iam.domain.model.commands.SeedRolesCommand;

/**
 * RoleCommandService
 * <p>
 *     Service to handle role commands.
 * </p>
 */
public interface RoleCommandService {
    /**
     * Handle seed roles command.
     *
     * @param command the {@link SeedRolesCommand} command
     */
    void handle(SeedRolesCommand command);
}