package com.dynoware.cargosafe.platform.iam.domain.model.commands;

import com.dynoware.cargosafe.platform.iam.domain.model.entities.Role;

import java.util.List;

import java.util.List;

/**
 * Command to sign up a new user.
 * <p>
 *     This command is used to sign up a new user in the system.
 *     It contains the username, password and roles of the new user.
 * </p>
 */
public record SignUpCommand(String username, String password, List<Role> roles) {
}