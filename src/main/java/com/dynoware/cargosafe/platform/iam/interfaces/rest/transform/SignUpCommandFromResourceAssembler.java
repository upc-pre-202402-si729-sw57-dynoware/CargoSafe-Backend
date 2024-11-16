package com.dynoware.cargosafe.platform.iam.interfaces.rest.transform;

import com.dynoware.cargosafe.platform.iam.domain.model.commands.SignUpCommand;
import com.dynoware.cargosafe.platform.iam.interfaces.rest.resources.SignUpResource;

/**
 * Assembler to convert a SignUpResource to a SignUpCommand.
 * <p>
 *     This class is used to convert a SignUpResource to a SignUpCommand.
 * </p>
 */
public class SignUpCommandFromResourceAssembler {
    /**
     * Converts a SignUpResource to a SignUpCommand.
     *
     * @param resource The SignUpResource to convert.
     * @return The SignUpCommand.
     */
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = RoleListFromStringAssembler.toRoleListFromStringList(resource.roles());
        System.out.println("roles: " + roles);
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }
}